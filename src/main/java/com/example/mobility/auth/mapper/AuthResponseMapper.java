package com.example.mobility.auth.mapper;

import com.example.mobility.auth.dto.response.LoginResponse;
import com.example.mobility.users.domain.UsersEntity;
import com.example.mobility.users.dto.response.JoinResponse;

public class AuthResponseMapper {
    public static JoinResponse from(Long id, String userId) {
        return new JoinResponse(id, userId);
    }

    public static LoginResponse from(UsersEntity usersEntity, String accessToken) {
        return LoginResponse.builder().id(usersEntity.getId()).accessToken(accessToken).build();
    }
}
