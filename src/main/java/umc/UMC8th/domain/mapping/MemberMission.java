package umc.UMC8th.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Mission;
import umc.UMC8th.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission {
    // 내가 설계한 ERD에는 없지만 필요한거 같아서 추가함 (유저 미션 관련)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime completedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private MissionStatus status; // 미션 상태 (미션 테이블에 있는 필드에서 여기로 변경함)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;
}
