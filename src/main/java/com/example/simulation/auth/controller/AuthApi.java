package com.example.simulation.auth.controller;

import com.example.simulation.auth.dto.request.LoginRequest;
import com.example.simulation.auth.dto.response.LoginResponse;
import com.example.simulation.common.api.Api;
import com.example.simulation.users.dto.request.JoinRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth Api", description = "인증 관련 API 목록입니다.")
public interface AuthApi {
    @Operation(summary = "회원 가입을 합니다.", description = "담당자: 서유진")
    Api<?> registerUser(JoinRequest userDto);

    @Operation(summary = "로그인을 합니다.", description = "담당자: 최민석")
    Api<LoginResponse> login(LoginRequest loginRequest);

}
