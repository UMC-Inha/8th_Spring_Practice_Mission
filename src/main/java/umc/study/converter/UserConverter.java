package umc.study.converter;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exceptition.GeneralException;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDto.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDto.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }
    public static User toUser(UserRequestDto.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case MALE -> gender = Gender.MALE;
            case FEMALE -> gender = Gender.FEMALE;
            case NONE -> gender = Gender.NONE;
            default -> throw new GeneralException(ErrorStatus.INVALID_GENDER);
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .birth(request.getBirth())
                .email(request.getEmail())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .userPreferList(new ArrayList<>())
                .build();
    }
}
