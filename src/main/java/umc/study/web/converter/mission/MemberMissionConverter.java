package umc.study.web.converter.mission;

import org.springframework.data.domain.Page;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mission.Mission;
import umc.study.repository.member.dto.MemberMissionIsCompletedResponseDto;
import umc.study.web.controller.mission.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static List<MemberMissionResponseDTO.MissionInProgressDTO> toMissionInProgressDTOList(
            List<MemberMissionIsCompletedResponseDto> memberMissionList) {

        return memberMissionList.stream()
                .map(mm -> MemberMissionResponseDTO.MissionInProgressDTO.builder()
                        .missionSpec(mm.getMissionSpec())
                        .storeName(mm.getStoreName())
                        .point(mm.getPoint())
                        .status(MissionStatus.IN_PROGRESS)
                        .build())
                .collect(Collectors.toList());
    }

    public static MemberMissionResponseDTO.MissionCompletedDTO toMissionCompletedDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MissionCompletedDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(memberMission.getStatus())
                .message("미션이 완료되었습니다.")
                .build();
    }
}
