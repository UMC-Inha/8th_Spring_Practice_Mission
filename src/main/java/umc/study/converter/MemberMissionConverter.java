package umc.study.converter;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.Mission.MemberMissionRequestDto;
import umc.study.web.dto.Mission.MemberMissionResponseDto;
import umc.study.web.dto.Mission.MissionResponseDto;

public class MemberMissionConverter {
    public static MemberMissionResponseDto.JoinResultDTO toJoinResultDTO(MemberMission memberMission){

        MissionResponseDto.JoinResultDTO missionResponseDto = MissionConverter.toJoinResultDTO(memberMission.getMission());

        return MemberMissionResponseDto.JoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionStatus(memberMission.getStatus().name())
                .missionResponseDto(missionResponseDto)
                .build();
    }

    public static MemberMission toMission(MemberMissionRequestDto.JoinDto request){

        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
