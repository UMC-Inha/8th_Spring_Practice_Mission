package umc.presentation.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import umc.common.validation.annotation.ExistCategories;
import umc.common.validation.annotation.ValidEnum;
import umc.infrastructure.persistence.entity.user.Gender;
import umc.infrastructure.persistence.entity.user.Role;

import java.util.List;

public class UserRequestDTO {

    public record JoinDto(@NotBlank String name,
                          @NotBlank @Email String email,
                          @NotBlank String password,
                          @ValidEnum(enumClass = Gender.class) String gender,
                          String address,
                          @ExistCategories List<Long> preferCategoryIdList,
                          @NotNull Role role){
        public JoinDto() {
            this(null, null, null, null, null, null, null);
        }
    }

    public record LoginRequestDto(
            @NotBlank(message = "이메일은 필수 입력값입니다.")
            @Email(message = "이메일 형식이 올바르지 않습니다.")
            String email,

            @NotBlank(message = "비밀번호는 필수 입력값입니다.")
            String password) {

    }

}
