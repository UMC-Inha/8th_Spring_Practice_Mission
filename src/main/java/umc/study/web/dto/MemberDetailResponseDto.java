package umc.study.web.dto;

public record MemberDetailResponseDto(
        Long memberId,
        String memberName,
        String email,
        String profileImageUrl,
        Boolean phoneVerified,
        String phoneNumber,
        Integer points
) {
}
