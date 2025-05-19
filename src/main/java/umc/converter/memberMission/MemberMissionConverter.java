package umc.converter.memberMission;

import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MissionResponseDTO.ChallengeMissionResultDto toChallengeMissionResultDto (MemberMission memberMission) {
        return MissionResponseDTO.ChallengeMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .missionStatus(memberMission.getMissionStatus())
                .startAt(memberMission.getStartAt())
                .doneAt(memberMission.getDoneAt())
                .build();
    }

    public static MemberMission toMemberMission (Member member, Mission mission) {
        return MemberMission.builder()
                .missionStatus(MissionStatus.ON)
                .member(member)
                .mission(mission)
                .startAt(LocalDateTime.now())
                .doneAt(mission.getDoneAt())
                .build();
    }
}
