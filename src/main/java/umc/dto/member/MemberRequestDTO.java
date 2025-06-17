package umc.dto.member;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.domain.enums.Gender;
import umc.domain.enums.LoginType;
import umc.domain.enums.Role;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto {
        @NotNull
        String name;
        @NotNull
        Gender gender;
        @NotNull
        String birth;
        @NotNull
        String address;
        @NotNull
        String mail;
        @NotNull
        String password;
        @NotNull
        LoginType loginSort;
        @NotNull
        String phoneNum;
        @NotNull
        Boolean isPhone;

        @NotNull
        List<Long> preferCategory;
        Role role;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO {
        private String mail;
        private String password;
    }
}
