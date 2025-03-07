package com.example.simulation.auth.mapper;

import com.example.simulation.users.domain.UsersEntity;
import com.example.simulation.users.dto.request.JoinRequest;

public class AuthEntityMapper {
    public static UsersEntity of(JoinRequest userDto, String encodedPassword) {
        return UsersEntity.builder()
                .userId(userDto.getUserId())
                .email(userDto.getEmail())
                .password(encodedPassword)
                .username(userDto.getUsername())
                .build();
    }
}
