package umc.study.web.converter.mission;

import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mission.Mission;
import umc.study.web.controller.mission.dto.MissionRequestDTO;
import umc.study.web.controller.mission.dto.MissionResponseDTO;


public class MissionConverter {
    public static MissionResponseDTO.AddResultDto toAddResultDTO(Mission mission) {
        return MissionResponseDTO.AddResultDto.builder()
                .missionSpec(mission.getMissionSpec())
                .missionId(mission.getId())
                .deadline(mission.getDeadline())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMission request) {

        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .local(request.getLocal())
                .deadline(request.getDeadline())
                .build();
    }

    public static MemberMission toMemberMission(MissionRequestDTO.AddMemberMission request) {
        return MemberMission.builder()
                .status(request.getMissionStatus())
                .build();
    }
}
