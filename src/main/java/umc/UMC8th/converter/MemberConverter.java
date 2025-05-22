package umc.UMC8th.converter;

import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.enums.Gender;
import umc.UMC8th.domain.enums.MemberStatus;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        return Member.builder()
                .email(request.getEmail())
                .name(request.getUserName())
                .phoneNumber(request.getUserPhone())
                .gender(convertGender(request.getUserGender()))
                .address(request.getUserAddress())
                .specAddress("상세주소 없음") // 분리 설계가 아니므로 임시 처리
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

    private static Gender convertGender(String genderString) {
        return switch (genderString.toUpperCase()) {
            case "M" -> Gender.MALE;
            case "F" -> Gender.FEMALE;
            default -> throw new IllegalArgumentException("성별을 입력하세요: " + genderString); // M,F 선택 안하면 예외 던지기
        };
    }


}
