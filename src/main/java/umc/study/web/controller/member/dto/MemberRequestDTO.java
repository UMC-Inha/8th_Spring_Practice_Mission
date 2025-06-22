package umc.study.web.controller.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    @Setter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotBlank
        Gender gender;
        @NotBlank
        LocalDate birth;
        @Size(min = 5, max = 12)
        String address;
        @NotBlank
        String phoneNumber;
        @NotBlank
        @Email
        String email;
        @Size(min = 5, max = 12)
        private List<Long> preferCategories;
        @NotNull
        Role role;
        @NotBlank
        String password;
    }
}
