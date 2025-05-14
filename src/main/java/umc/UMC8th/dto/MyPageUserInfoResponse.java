package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageUserInfoResponse {
    private Long userId;
    private String userNickname;
    private String userEmail;
    private String userPhoneNumber;
    private Boolean userPhoneVerity;
    private Integer userPoints;
    private Integer totalPointsEarned;
    private Long totalReviewWrite;
}
