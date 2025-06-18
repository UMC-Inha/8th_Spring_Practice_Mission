package umc.spring.converter;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDTO.PreviewMyMissionDto previewMyMissionDto(MemberMission memberMission) {
        return MemberMissionResponseDTO.PreviewMyMissionDto.builder()
                .missionId(memberMission.getId())
                .title(memberMission.getMission().getTitle())
                .content(memberMission.getMission().getContent())
                .reward(memberMission.getMission().getReward())
                .dueDate(memberMission.getDueDate().toLocalDate())
                .missionStatus(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberMissionResponseDTO.PreviewMyMissionListDto PreviewMyMissionResultListDto (Page<MemberMission> memberMissionList) {

        List<MemberMissionResponseDTO.PreviewMyMissionDto> missionList = memberMissionList.getContent().stream()
                .map(MemberMissionConverter::previewMyMissionDto).collect(Collectors.toList());

        return MemberMissionResponseDTO.PreviewMyMissionListDto.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionList.size())
                .missionList(missionList)
                .build();
    }

    public static MemberMissionResponseDTO.ChangeMissionStatusByMemberDto toChangeMissionStatusByMemberDto(MemberMission memberMission){
        return MemberMissionResponseDTO.ChangeMissionStatusByMemberDto.builder()
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
