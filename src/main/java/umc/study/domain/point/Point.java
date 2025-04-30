package umc.study.domain.point;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.BaseTime;
import umc.study.domain.enums.PointStatus;
import umc.study.domain.enums.PointType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Point extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @Column(nullable = false)
    private int point;
}
