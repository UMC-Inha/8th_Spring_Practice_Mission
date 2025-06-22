package umc.study.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDto{
        @NotNull
        String name;
        @NotNull
        Gender gender;
        @NotNull
        String birth;
        @Size(min = 5, max = 12)
        @NotNull
        String address;
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        String phoneNumber;
        @ExistCategories
        @NotNull
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}
