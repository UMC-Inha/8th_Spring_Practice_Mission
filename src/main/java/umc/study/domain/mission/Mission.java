package umc.study.domain.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.BaseTime;
import umc.study.domain.mapping.PointMission;
import umc.study.domain.point.Point;
import umc.study.domain.store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 100)
    private String local;

    @Column(nullable = false)
    private LocalDateTime deadline;


    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<PointMission> pointMission = new ArrayList<>();
}