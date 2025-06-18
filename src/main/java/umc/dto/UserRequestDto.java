package umc.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.domain.enums.Gender;
import umc.domain.enums.Role;
import umc.validation.annotation.ExistCategories;

public class UserRequestDto {

	@Getter
	@Setter	// 폼 로그인 post 용 임시
	public static class JoinDto {
		@NotBlank
		String name;
		@NotBlank
		String email;
		@NotBlank
		String password;
		@NotNull
		String gender;
		@NotNull
		LocalDate birthDate;
		@Size(min = 1, max = 100)
		String address;
		@Size(min = 1, max = 100)
		String addressDetail;
		@ExistCategories
		List<Long> preferCategory;
		@NotNull
		String role;    // 역할 필드 추가
	}

	@Getter
	public static class LoginRequestDto{
		@NotBlank(message = "이메일은 필수입니다.")
		@Email(message = "올바른 이메일 형식이어야 합니다.")
		private String email;

		@NotBlank(message = "패스워드는 필수입니다.")
		private String password;
	}

	@Getter
	public static class ReissueDto {
		@NotBlank
		private String accessToken;
		@NotBlank
		private String refreshToken;
	}
}
