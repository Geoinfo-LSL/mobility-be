package com.example.mobility.auth.controller;

import com.example.mobility.auth.dto.request.LoginRequest;
import com.example.mobility.auth.dto.response.LoginResponse;
import com.example.mobility.auth.service.AuthService;
import com.example.mobility.common.api.Api;
import com.example.mobility.common.type.AuthSuccessType;
import com.example.mobility.users.dto.request.JoinRequest;
import com.example.mobility.users.dto.response.JoinResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/open-api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public Api<?> registerUser(@Valid @RequestBody JoinRequest userDto) {
        JoinResponse joinResponse = authService.joinProcess(userDto);
        return Api.success(AuthSuccessType.SIGN_UP, joinResponse);
    }

    @PostMapping("/sign-in")
    public Api<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return Api.success(AuthSuccessType.SIGN_IN, loginResponse);
    }
}
