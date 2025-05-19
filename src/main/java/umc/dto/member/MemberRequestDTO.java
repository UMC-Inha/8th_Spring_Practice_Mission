package umc.dto.member;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.domain.enums.Gender;
import umc.domain.enums.LoginType;

import java.util.List;

public class MemberRequestDTO {

    @Getter
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
        LoginType loginSort;
        @NotNull
        String phoneNum;
        @NotNull
        Boolean isPhone;

        @NotNull
        List<Long> preferCategory;
    }
}
