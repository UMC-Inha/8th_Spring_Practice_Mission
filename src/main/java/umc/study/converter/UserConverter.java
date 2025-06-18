package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exceptition.GeneralException;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static UserResponseDto.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDto.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }
    public static User toUser(UserRequestDto.JoinDto request){

        Gender gender = Gender.fromDescription(String.valueOf(request.getGender()));

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

    public static UserResponseDto.OngoingMissionListDTO toOngoingMissionListDTO(Page<UserMission> missionPage) {
        List<UserResponseDto.MissionDTO> list = missionPage.stream()
                .map(um -> UserResponseDto.MissionDTO.builder()
                        .missionId(um.getMission().getId())
                        .missionSpec(um.getMission().getMissionSpec())
                        .point(um.getMission().getPoint())
                        .build())
                .toList();

        return UserResponseDto.OngoingMissionListDTO.builder()
                .missions(list)
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(list.size())
                .build();
    }

}
