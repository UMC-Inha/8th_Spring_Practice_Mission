package umc.study.converter;

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
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static User toUser(UserRequestDto.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
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
