package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResponse {
    private Long inquiryId;
    private Long notificationId;
    private String inquiryTitle;
    private String inquiryContent;
    private LocalDateTime inquiryCreatedAt;
}
