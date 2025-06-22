package umc.UMC8th.converter;

import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.enums.Gender;
import umc.UMC8th.domain.enums.MemberStatus;
import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        return Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword()) // password 추가
                .phoneNumber(request.getPhoneNumber())
                .gender(convertGender(request.getGender()))
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .region(request.getRegion())
                .status(MemberStatus.ACTIVE)
                .points(0)
                .memberPrefers(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.JoinResultDto toJoinResultDto(Member member, String foodCategory) {
        return MemberResponseDTO.JoinResultDto.builder()
                .userId(member.getId())
                .email(member.getEmail())
                .nickname(member.getName()) // 닉네임 필드는 Entity에 없으므로 name으로 대체
                .userBirth(LocalDate.of(1998, 7, 24)) // 엔티티에 없으므로 더미
                .userAddress(member.getAddress())
                .foodCategories(foodCategory)
                .createdAt(LocalDateTime.now())
                .build();
    }

    private static Gender convertGender(Integer gender) {
        return switch (gender) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            default -> throw new IllegalArgumentException("성별을 선택하세요"); // M,F 선택 안하면 예외 던지기
        };
    }

    public static MemberResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return MemberResponseDTO.MyReviewDTO.builder()
                .storeName(review.getStore().getName())
                .rating(review.getRating().floatValue())
                .content(review.getReviewText())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage) {
        List<MemberResponseDTO.MyReviewDTO> reviewDTOs = reviewPage.getContent().stream()
                .map(MemberConverter::toMyReviewDTO)
                .toList();

        return MemberResponseDTO.MyReviewListDTO.builder()
                .reviewList(reviewDTOs)
                .listSize(reviewDTOs.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }

    public static MemberResponseDTO.MissionPreviewDTO toMissionPreviewDTO(MemberMission memberMission) {
        return MemberResponseDTO.MissionPreviewDTO.builder()
                .title(memberMission.getMission().getTitle())
                .explanation(memberMission.getMission().getExplanation())
                .deadline(memberMission.getMission().getDeadline())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    public static MemberResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<MemberMission> page) {
        List<MemberResponseDTO.MissionPreviewDTO> list = page.getContent().stream()
                .map(MemberConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return MemberResponseDTO.MissionPreviewListDTO.builder()
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .listSize(list.size())
                .missionList(list)
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long userId, String token) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .userId(userId)
                .accessToken(token)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }

}
