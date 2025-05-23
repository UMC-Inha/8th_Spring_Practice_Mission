package umc.study.web.controller.member.dto;

import lombok.Getter;
import umc.study.domain.enums.Gender;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        String name;
        Gender gender;
        LocalDate birth;
        String address;
        String phoneNumber;
        String email;
        List<Long> preferCategory;
    }
}
