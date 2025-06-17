package umc.converter;

import java.time.LocalDateTime;

import umc.domain.Region;
import umc.domain.User;
import umc.domain.enums.Gender;
import umc.domain.enums.Role;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;

public class UserConverter {

	public static UserResponseDto.JoinResultDTO toJoinResultDto(User user) {
		return UserResponseDto.JoinResultDTO.builder()
			.userId(user.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static User toUser(UserRequestDto.JoinDto request, Region region) {

		Gender gender = null;

		switch (request.getGender()) {
			case "MALE":
				gender = Gender.MALE;
				break;
			case "FEMALE":
				gender = Gender.FEMALE;
				break;
			case "NONE":
				gender = Gender.NONE;
				break;
		}

		return User.builder()
			.name(request.getName())
			.email(request.getEmail())
			.gender(Gender.valueOf(request.getGender()))
			.birth(request.getBirthDate())
			.addressDetail(request.getAddressDetail())
			.region(region)
			.role(Role.valueOf(request.getRole()))
			.build();
	}
}
