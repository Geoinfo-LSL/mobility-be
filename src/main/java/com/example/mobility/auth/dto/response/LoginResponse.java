package com.example.simulation.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoginResponse(
        @NotNull @Schema(description = "회원 ID", example = "1") Long id,
        @NotBlank @Schema(description = "회원 AccessToken", example = "Bearer abcd...")
                String accessToken,
        @NotBlank @Schema(description = "회원 RefreshToken", example = "Bearer abcd...")
                String refreshToken) {
    @Builder
    public LoginResponse(Long id, String accessToken, String refreshToken) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
