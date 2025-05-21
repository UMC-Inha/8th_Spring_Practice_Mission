package umc.converter;

import java.time.LocalDateTime;

import umc.domain.User;
import umc.domain.enums.Gender;
import umc.dto.UserRequestDto;
import umc.dto.UserResponseDto;

public class UserConverter {

	public static UserResponseDto.JoinResultDTO toJoinResultDto(User user) {
		return UserResponseDto.JoinResultDTO.builder()
			.userId(user.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static User toUser(UserRequestDto.JoinDto request) {

		Gender gender = null;

		switch (request.getGender()) {
			case MALE:
				gender = Gender.MALE;
				break;
			case FEMALE:
				gender = Gender.FEMALE;
				break;
			case NONE:
				gender = Gender.NONE;
				break;
		}

		return User.builder()
			.name(request.getName())
			.email(request.getEmail())
			.gender(request.getGender())
			.birth(request.getBirthDate())
			.addressDetail(request.getAddressDetail())
			.build();
	}
}
