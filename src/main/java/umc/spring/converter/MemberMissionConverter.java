package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.mission.MissionResponseDTO;

public class MemberMissionConverter {

    public static MissionResponseDTO.ChallengeMissionResultDto toChallengeMissionResultDto (MemberMission memberMission){
        return MissionResponseDTO.ChallengeMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .status(memberMission.getStatus())
                .missionId(memberMission.getMission().getId())
                .dueDate(memberMission.getDueDate())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .dueDate(mission.getDueDate())
                .build();
    }
}
