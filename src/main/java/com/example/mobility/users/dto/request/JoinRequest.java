package com.example.simulation.users.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequest {
    @NotBlank(message = "사용자의 ID를 입력해주세요.")
    @Schema(description = "사용자의 ID", example = "test123")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Schema(description = "사용자의 비밀번호", example = "testpassword")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하여야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호를 확인해주세요.")
    @Schema(description = "비밀번호 확인", example = "testpassword")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하여야 합니다.")
    private String passwordConfirm;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    @Schema(description = "사용자의 이메일", example = "example@gmail.com")
    private String email;

    @NotBlank(message = "사용자의 이름을 입력해주세요.")
    @Schema(description = "사용자의 이름", example = "아무개")
    private String username;

    @Builder
    public JoinRequest(
            String userId, String email, String password, String passwordConfirm, String username) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.username = username;
    }
}
