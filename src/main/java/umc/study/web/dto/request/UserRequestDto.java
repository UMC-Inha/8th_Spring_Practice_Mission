package umc.study.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDto {

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }

    @Getter
    @Setter
    public static class JoinDto {

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotNull(message = "성별은 필수입니다.")
        private Gender gender;

        @NotNull(message = "생년월일은 필수입니다.")
        private LocalDate birthday;

        @NotBlank(message = "주소는 필수입니다.")
        private String address;
        private String specAddress; // 상세주소

        @Email(message = "이메일 형식이 아닙니다.")
        private String email;

        @NotBlank
        private String password;

        @NotBlank(message = "전화번호는 필수입니다.")
        private String phoneNumber;

        @NotNull
        @ExistCategories
        private List<Long> preferCategory;

        @NotNull
        private Role role;
    }
}