package com.example.simulation.auth.controller;

import com.example.simulation.auth.dto.request.LoginRequest;
import com.example.simulation.auth.dto.response.LoginResponse;
import com.example.simulation.auth.service.AuthService;
import com.example.simulation.common.api.Api;
import com.example.simulation.common.type.AuthSuccessType;
import com.example.simulation.users.dto.request.JoinRequest;
import com.example.simulation.users.dto.response.JoinResponse;
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
