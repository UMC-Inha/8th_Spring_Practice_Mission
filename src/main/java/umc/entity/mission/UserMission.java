package umc.entity.mission;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import umc.entity.BaseTimeEntity;
import umc.entity.user.User;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_mission")
public class UserMission extends BaseTimeEntity {
    @EmbeddedId
    private UserMissionPK id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("userId")                       // id.storeId 컬럼과 매핑
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("missionId")                    // id.categoryId 컬럼과 매핑
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private MissionState state;
}
