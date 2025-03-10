package com.example.mobility.auth.mapper;

import com.example.mobility.users.domain.UsersEntity;
import com.example.mobility.users.dto.request.JoinRequest;

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
