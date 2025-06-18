package umc.converter;

import java.time.LocalDateTime;

import umc.domain.Region;
import umc.domain.User;
import umc.domain.enums.Gender;
import umc.domain.enums.Role;
import umc.domain.security.RefreshToken;
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

	public static UserResponseDto.LoginResultDTO toLoginResultDto(Long userId, String accessToken, String refreshToken) {

		return UserResponseDto.LoginResultDTO.builder()
			.userId(userId)
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}

	public static UserResponseDto.UserInfoDTO toUserInfoDTO(User user) {

		return UserResponseDto.UserInfoDTO.builder()
			.name(user.getName())
			.email(user.getEmail())
			.gender(user.getGender().getDescription())
			.build();
	}

	public static UserResponseDto.ReissueDto toReissueDto(String accessToken, String refreshToken) {

		return UserResponseDto.ReissueDto.builder()
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}

	public static RefreshToken toRefreshToken(String email, String refreshToken) {

		return RefreshToken.builder()
			.email(email)
			.value(refreshToken)
			.build();
	}

	public static User toKakaoUser(String email, String name) {
		return User.builder()
			.email(email)
			.password("")
			.name(name)
			.role(Role.USER)
			.build();
	}
}
