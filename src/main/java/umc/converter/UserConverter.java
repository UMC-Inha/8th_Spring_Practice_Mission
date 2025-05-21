package umc.converter;

import umc.domain.User;
import umc.domain.enums.Status;
import umc.web.dto.user.UserRequestDTO;
import umc.web.dto.user.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .role("ROLE_USER")
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .status(Status.ACTIVE)
                .totalPoint(0)
                .isPhoneVerified(false)
                .email(request.getEmail())
                .userPreferenceList(new ArrayList<>())
                .build();
    }

}
