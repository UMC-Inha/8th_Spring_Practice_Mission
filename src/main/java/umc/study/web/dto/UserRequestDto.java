package umc.study.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.domain.enums.Gender;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

@AllArgsConstructor
public class UserRequestDto {
    @Getter
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
        //@NotNull
        String email;
        @NotNull
        String phoneNumber;
        @ExistCategories
        @NotNull
        List<Long> preferCategory;
    }
}
