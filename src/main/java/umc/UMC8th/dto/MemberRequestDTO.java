package umc.UMC8th.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.UMC8th.domain.enums.Role;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class JoinDto {

        @NotBlank
        private String email;

        @NotBlank
        private String password;

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

        @NotNull
        Role role;

        @Size(min = 5, max = 40)
        private String specAddress;
    }
}
