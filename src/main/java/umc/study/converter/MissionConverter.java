package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.Mission.MissionRequestDto;
import umc.study.web.dto.Mission.MissionResponseDto;

import java.util.ArrayList;

public class MissionConverter {
    public static MissionResponseDto.JoinResultDTO toJoinResultDTO(Mission mission){

        return MissionResponseDto.JoinResultDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDto.JoinDto request){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
