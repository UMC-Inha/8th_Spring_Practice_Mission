package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member) {
        return MemberMission.builder()
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.challengeResultDTO toChallengeResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.challengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MyMemberMissionSliceDTO toMyMemberMissionSliceDTO(List<MemberMissionResponseDTO.MyMemberMissionDTO> myMemberMissionDTOList, int size) {
        boolean hasNext = myMemberMissionDTOList.size() > size;
        // 빈 리스트이면 커서 null 처리
        Long cursorId = null;
        LocalDateTime cursorCreatedAt = null;

        List<MemberMissionResponseDTO.MyMemberMissionDTO> trimmedList = hasNext ? myMemberMissionDTOList.subList(0, size) : myMemberMissionDTOList;
        if (hasNext) {
            MemberMissionResponseDTO.MyMemberMissionDTO cursor = trimmedList.get(trimmedList.size() - 1);
            cursorId = cursor.getMemberMissionId();
            cursorCreatedAt = cursor.getCreatedAt();
        }

        return MemberMissionResponseDTO.MyMemberMissionSliceDTO.builder()
                .memberMissionList(trimmedList)
                .cursorId(cursorId)
                .cursorCreatedAt(cursorCreatedAt)
                .hasNext(hasNext)
                .build();
    }
}
