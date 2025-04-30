package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.BaseTime;
import umc.study.domain.enums.PointStatus;
import umc.study.domain.enums.PointType;
import umc.study.domain.member.Member;
import umc.study.domain.point.Point;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PointMember extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_member_id")
    private Long id;

    @Column(nullable = false, length = 255)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PointStatus pointStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PointType pointType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    private Point point;
}
