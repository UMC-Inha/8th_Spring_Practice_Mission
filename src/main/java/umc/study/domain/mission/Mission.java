package umc.study.domain.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long missionId;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    private String title;

    @Column(name = "mission_content", columnDefinition = "TEXT")
    private String missionContent;

    @Column(name = "reward_point")
    private Integer rewardPoint;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> userMissions = new ArrayList<>();
}
