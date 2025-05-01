package umc.UMC8th.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.common.BaseEntity;
import umc.UMC8th.domain.enums.NotificationStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewAnswerNotification extends BaseEntity {
    // 리뷰 답변 알림 관련
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id", nullable = false)
    private Notification notification;
}
