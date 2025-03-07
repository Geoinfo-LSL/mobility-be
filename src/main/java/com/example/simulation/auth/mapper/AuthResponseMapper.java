package com.example.simulation.auth.mapper;

import com.example.simulation.auth.dto.response.LoginResponse;
import com.example.simulation.users.domain.UsersEntity;
import com.example.simulation.users.dto.response.JoinResponse;

public class AuthResponseMapper {
    public static JoinResponse from(Long id, String userId) {
        return new JoinResponse(id, userId);
    }

    public static LoginResponse from(UsersEntity usersEntity, String accessToken){
     return LoginResponse.builder()
             .id(usersEntity.getId())
            .accessToken(accessToken)
                .build();
    }
}
