package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeDTO.MissionChallengeResponseDTO;
import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MissionChallengeResponseDTO.MissionChallengeJoinResultDTO missionChallengeJoinResultDTO(MemberMission memberMission) {
        return MissionChallengeResponseDTO.MissionChallengeJoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MissionChallengeRequestDTO.MissionChallengeJoinDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }
}
