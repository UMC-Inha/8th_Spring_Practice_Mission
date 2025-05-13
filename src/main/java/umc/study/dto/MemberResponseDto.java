package umc.study.dto;

public record MemberResponseDto(
        Long memberId,
        String memberName,
        String email,
        String profileImageUrl,
        Boolean phoneVerified,
        String phoneNumber,
        Integer points
) {
}
