package umc.UMC8th.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class JoinDto {

        @NotBlank
        private String email;

        @NotBlank
        private String password; // 현재 나의 엔티티 필드에는 없는데 저장은 하지 않아도 있어야할거같아서 넣음

        @NotBlank
        private String userName;

        @NotBlank
        private String nickname;

        @NotNull
        private Integer userAge;

        @NotBlank
        private String userGender;

        @NotBlank
        private String userPhone;

        @NotNull
        private LocalDate userBirth;

        @NotBlank
        private String userAddress;

        @NotEmpty
        private List<Long> foodCategories;

        @NotBlank
        private String region;
    }
}
