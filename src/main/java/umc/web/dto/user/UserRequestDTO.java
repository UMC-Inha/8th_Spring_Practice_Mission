package umc.web.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.domain.enums.Gender;
import umc.domain.enums.Role;
import umc.validation.annotation.ExistCategories;

import java.time.LocalDateTime;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String username;
        @NotBlank
        String password;
        @NotBlank
        String nickname;
        @NotBlank
        String phoneNumber;
        @NotNull
        LocalDateTime birthDate;
        @NotNull
        Gender gender;
        @NotBlank
        @Email
        String email;
        @NotNull
        Role role;    // 역할 필드 추가
        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}