package umc.study.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDto {

    @Getter
    @Setter
    public static class JoinDto {

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        @NotNull(message = "성별은 필수입니다.")
        private Gender gender;

        @NotNull(message = "생년월일은 필수입니다.")
        private Integer birthYear;

        @NotNull(message = "생월은 필수입니다.")
        private Integer birthMonth;

        @NotNull(message = "생일은 필수입니다.")
        private Integer birthDay;

        @NotBlank(message = "주소는 필수입니다.")
        private String address;
        private String specAddress; // 상세주소

        @Email(message = "이메일 형식이 아닙니다.")
        private String email;

        @NotBlank(message = "전화번호는 필수입니다.")
        private String phoneNumber;

        @NotNull
        @ExistCategories
        private List<Long> preferCategory;
    }
}