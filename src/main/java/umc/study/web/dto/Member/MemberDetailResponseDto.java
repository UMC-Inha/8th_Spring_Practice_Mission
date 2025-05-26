package umc.study.web.dto.Member;

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
