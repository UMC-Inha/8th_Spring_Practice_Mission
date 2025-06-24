package umc.study.converter;

import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;
import umc.study.domain.user.User;
import umc.study.web.dto.request.UserRequestDto;
import umc.study.web.dto.response.UserResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDto.JoinResultDTO toJoinResultDto(User user) {
        return UserResponseDto.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static User toUser(UserRequestDto.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case F:
                gender = Gender.F;
                break;
            case M:
                gender = Gender.M;
                break;
        }
        return User.builder()
                .name(request.getName())
                .address(request.getAddress() + " " + request.getSpecAddress())
                .gender(gender)
                .preferFoods(new ArrayList<>())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .birth(request.getBirthday())
                .status(UserStatus.ACTIVE)
                .point(0)
                .missionCompleted(0)
                .build();

    }
}
