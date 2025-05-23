package umc.infrastructure.persistence.entity.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.infrastructure.persistence.entity.BaseTimeEntity;
import umc.infrastructure.persistence.entity.user.User;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_mission")
@Getter
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
    @Builder.Default
    private MissionState state = MissionState.ING;

    public void setUser(User user) {
        if (this.user != null) {
            this.user.getUserMissions().remove(this);
        }
        this.user = user;
        user.getUserMissions().add(this);
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
