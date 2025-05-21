package umc.web.dto.user;

import lombok.Getter;
import umc.domain.enums.Gender;
import umc.validation.annotation.ExistCategories;

import java.time.LocalDateTime;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String username;
        String password;
        String nickname;
        String phoneNumber;
        LocalDateTime birthDate;
        Gender gender;
        String email;
        @ExistCategories
        List<Long> preferCategory;
    }
}