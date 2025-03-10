package com.example.mobility.common.utils;

import com.example.mobility.common.exception.UnauthorizedException;
import com.example.mobility.common.type.AuthErrorType;
import com.example.mobility.users.domain.UsersEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtils {
    private final SecretKey key;

    public JwtUtils(Environment env) {
        String secretKeyString = env.getProperty("token.secret");
        byte[] decodedKey = Base64.getDecoder().decode(secretKeyString);
        this.key = Keys.hmacShaKeyFor(decodedKey);
    }

    // Access Token 생성 (50시간 유효)
    public String generateAccessToken(String name, Long id) {
        Date nowDate = new Date();
        Date expiration = new Date(nowDate.getTime() + Duration.ofHours(50).toMillis());
        return Jwts.builder()
                .claim("name", name)
                .claim("sub", "simulation")
                .claim("jti", id)
                .claim("iat", nowDate)
                .claim("exp", expiration)
                .signWith(key)
                .compact();
    }

    // JWT에서 Claims 추출, 만료되었으면 예외 발생
    private Claims getAllClaimsFromToken(String token) {
        try {
            Jws<Claims> jwt = Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return jwt.getPayload();
        } catch (ExpiredJwtException exception) {
            throw new UnauthorizedException(AuthErrorType.TOKEN_NOT_FOUND);
        }
    }

    // 토큰에서 사용자 이름 추출
    public String getNameFromToken(String token) {
        return getAllClaimsFromToken(token).get("name", String.class);
    }

    // 토큰 만료 날짜 추출
    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    // 토큰이 만료되었는지 확인
    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // 토큰 유효성 검사 및 사용자 ID 일치 확인
    public boolean validateToken(String token, UsersEntity usersEntity) {
        if (isTokenExpired(token)) {
            return false;
        }

        Long jwtId = getIdFromToken(token);
        Long id = usersEntity.getId();

        return jwtId != null && Objects.equals(jwtId, id);
    }

    // Authorization 헤더에서 "Bearer " 제거 후 토큰 반환
    public String extractTokenFromHeader(String authorizationHeader) {
        return authorizationHeader.startsWith("Bearer ")
                ? authorizationHeader.substring(7)
                : authorizationHeader;
    }

    // 토큰에서 사용자 ID 추출
    public Long getIdFromToken(String token) {
        return getAllClaimsFromToken(token).get("jti", Long.class);
    }
}
