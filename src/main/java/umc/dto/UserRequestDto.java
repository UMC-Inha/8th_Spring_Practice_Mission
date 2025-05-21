package umc.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.domain.enums.Gender;
import umc.validation.annotation.ExistCategories;

public class UserRequestDto {

	@Getter
	public static class JoinDto {
		@NotBlank
		String name;
		@NotBlank
		String email;
		@NotNull
		Gender gender;
		@NotNull
		LocalDate birthDate;
		@Size(min = 1, max = 100)
		String address;
		@Size(min = 1, max = 100)
		String addressDetail;
		@ExistCategories
		List<Long> preferCategory;
	}
}
