package umc.UMC8th.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.common.BaseEntity;
import umc.UMC8th.domain.enums.MemberStatus;
import umc.UMC8th.domain.enums.MissionStatus;
import umc.UMC8th.domain.mapping.MemberMission;

import java.time.LocalDate;
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
    private Long id;

    private String title; // 미션 제목

    @Column(columnDefinition = "TEXT")
    private String explanation; // 미션 설명

    private Integer rewardPoints; // 완료 후 지급 포인트

    private String completedNumber; // 인증 번호

    private LocalDate deadline; // 마감 기한

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // MemberMission 양방향 설정
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberMission> memberMissions = new ArrayList<>();
}
