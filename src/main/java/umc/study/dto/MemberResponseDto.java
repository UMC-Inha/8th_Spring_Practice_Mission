package umc.study.dto;

public record MemberResponseDto(
        Long memberId,
        String memberName,
        String email,
        Boolean phoneVerified,
        String phoneNumber,
        Integer points
) {
}
