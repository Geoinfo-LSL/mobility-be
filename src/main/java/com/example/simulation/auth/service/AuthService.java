package com.example.simulation.auth.service;

import com.example.simulation.auth.dto.request.LoginRequest;
import com.example.simulation.auth.dto.response.LoginResponse;
import com.example.simulation.auth.mapper.AuthEntityMapper;
import com.example.simulation.auth.mapper.AuthResponseMapper;
import com.example.simulation.common.exception.NotFoundException;
import com.example.simulation.common.type.AuthErrorType;
import com.example.simulation.common.utils.JwtUtils;
import com.example.simulation.users.domain.UsersEntity;
import com.example.simulation.users.dto.request.JoinRequest;
import com.example.simulation.users.dto.response.JoinResponse;
import com.example.simulation.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import com.example.simulation.common.exception.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UsersRepository usersRepository;
    private final JwtUtils jwtUtils;
    public JoinResponse joinProcess(JoinRequest userDto) {
        String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        UsersEntity users = usersRepository.save(AuthEntityMapper.of(userDto, encodedPassword));

        return AuthResponseMapper.from(users.getId(), users.getUserId());
    }



    public LoginResponse login(LoginRequest loginRequest) {
        UsersEntity usersEntity =
                usersRepository
                        .findByUserId(loginRequest.id())
                        .orElseThrow(() -> new NotFoundException(AuthErrorType.NOT_FOUND));


        String accessToken =
                jwtUtils.generateAccessToken(usersEntity.getUsername(), usersEntity.getId());

        boolean passwordMatch =
                bCryptPasswordEncoder.matches(loginRequest.password(), usersEntity.getPassword());
        if (!passwordMatch) {
            throw new BadRequestException(AuthErrorType.PASSWORD_NOT_MATCH);
        }

        return AuthResponseMapper.from(usersEntity, accessToken);
    }


}
