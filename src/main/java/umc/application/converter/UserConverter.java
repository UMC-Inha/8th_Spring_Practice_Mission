package umc.application.converter;

import umc.infrastructure.persistence.entity.user.Gender;
import umc.infrastructure.persistence.entity.user.User;
import umc.presentation.dto.user.UserRequestDTO;
import umc.presentation.dto.user.UserResponseDTO;

public class UserConverter {
    public static UserResponseDTO.JoinResultDto toJoinResultDto(User user) {
        return UserResponseDTO.JoinResultDto.builder()
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }


    public static User toUser(UserRequestDTO.JoinDto request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .gender(Gender.valueOf(request.gender()))
                .address(request.address())
                //build default 설정 했음. userPreferList 설정 필요 없다.
                .role(request.role())
                .build();

    }
}
