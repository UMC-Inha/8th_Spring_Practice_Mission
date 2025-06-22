package umc.UMC8th.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.UMC8th.domain.enums.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class JoinDto {

        @NotBlank
        private String email;

        @NotBlank
        private String password;

        @NotBlank
        private String name;

        @NotBlank
        private String nickname;

        /*
        @NotNull
        private Integer userAge;
         */

        @NotNull(message = "성별은 필수 항목입니다.")
        private Integer gender; // converter에서 case 경우를 Integer로 수정해서 여기도 변경

        @NotBlank
        private String phoneNumber;

        @NotNull
        private Integer birthYear;

        @NotNull
        private Integer birthMonth;

        @NotNull
        private Integer birthDay;


        @NotBlank
        private String address;

        @NotEmpty
        private List<Long> preferCategory = new ArrayList<>();

        @NotBlank
        private String region;

        @NotNull
        Role role;

        @Size(min = 5, max = 40)
        private String specAddress;
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
