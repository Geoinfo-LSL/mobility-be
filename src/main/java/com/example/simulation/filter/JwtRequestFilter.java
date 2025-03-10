package com.example.simulation.filter;

import com.example.simulation.common.utils.JwtUtils;
import com.example.simulation.users.repository.UsersRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final UsersRepository usersRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //        String uri = request.getRequestURI();
        //        if (uri.contains("/open-api")
        //                || uri.contains("/swagger-ui")
        //                || uri.contains("/v3/api-docs")
        //                || uri.contains("/static")) {
        //            filterChain.doFilter(request, response);
        //            return;
        //        }
        //
        //        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        //        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
        //            log.error("Authorization 헤더 누락 또는 토큰 형식 오류");
        //            throw new UnauthorizedException(AuthErrorType.HEADER_INVALID);
        //        }
        //
        //        // JWT 추출 및 검증
        //        String jwtToken = jwtUtils.extractTokenFromHeader(authorizationHeader);
        //        log.debug("JWT: {}", jwtToken);
        //
        //        Long jwtId = jwtUtils.getIdFromToken(jwtToken);
        //
        //        if (SecurityContextHolder.getContext().getAuthentication() != null) {
        //            filterChain.doFilter(request, response);
        //            return;
        //        }
        //
        //        // 사용자 정보 조회
        //        UsersEntity usersEntity =
        //                usersRepository
        //                        .findById(jwtId)
        //                        .orElseThrow(() -> new
        // NotFoundException(AuthErrorType.NOT_FOUND));
        //
        //        log.debug("인증된 사용자: {}", usersEntity.getEmail());
        //
        //        if (!jwtUtils.validateToken(jwtToken, usersEntity)) {
        //            throw new UnauthorizedException(AuthErrorType.TOKEN_EXPIRED);
        //        }
        //
        //        CustomUserDetail customUserDetail = new CustomUserDetail(usersEntity);
        //        UsernamePasswordAuthenticationToken authentication =
        //                new UsernamePasswordAuthenticationToken(
        //                        customUserDetail, null, customUserDetail.getAuthorities());
        //        authentication.setDetails(new
        // WebAuthenticationDetailsSource().buildDetails(request));
        //
        //        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
