package umc.converter.memberMission;

import org.springframework.data.domain.Page;
import umc.converter.mission.MissionConverter;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.Restaurant;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

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

    public static MissionResponseDTO.PreviewMissionWithStatusDto toPreviewMissionWithStatusDto (MemberMission memberMission) {
        return MissionResponseDTO.PreviewMissionWithStatusDto.builder()
                .missionPrice(memberMission.getMission().getMissionPrice())
                .content(memberMission.getMission().getContent())
                .reward(memberMission.getMission().getReward())
                .doneAt(memberMission.getDoneAt().toLocalDate())
                .missionStatus(memberMission.getMissionStatus())
                .build();
    }

    public static MissionResponseDTO.PreviewMemberMissionListDto previewMemberMissionListDto (Page<MemberMission> memberMissionList) {

        List<MissionResponseDTO.PreviewMissionWithStatusDto> missionList = memberMissionList.getContent().stream()
                .map(MemberMissionConverter::toPreviewMissionWithStatusDto).toList();

        return MissionResponseDTO.PreviewMemberMissionListDto.builder()
                .missionList(missionList)
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .listSize(missionList.size())
                .totalElements(memberMissionList.getTotalElements())
                .totalPage(memberMissionList.getTotalPages())
                .build();
    }

    public static MissionResponseDTO.ChangeMissionStatusByMemberDto toChangeMissionStatusByMemberDto(MemberMission memberMission) {
        return MissionResponseDTO.ChangeMissionStatusByMemberDto.builder()
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
