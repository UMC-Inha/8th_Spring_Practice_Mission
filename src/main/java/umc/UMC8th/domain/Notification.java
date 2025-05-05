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
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String message; // 알림 메세지

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // 알림 수신 상태
}
