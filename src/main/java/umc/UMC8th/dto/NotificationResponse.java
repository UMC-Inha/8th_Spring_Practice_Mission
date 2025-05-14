package umc.UMC8th.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long notificationId;
    private String notificationMessage;
    private String notificationStatus;
    private LocalDateTime notificationCreatedAt;
    private LocalDateTime notificationUpdatedAt;
}
