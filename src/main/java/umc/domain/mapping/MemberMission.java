package umc.domain.mapping;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.Member;
import umc.domain.Mission;
import umc.domain.common.BaseEntity;
import umc.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    private MissionStatus missionStatus;

    private LocalDateTime startAt;

    private LocalDateTime doneAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void changeMissionStatus() {
        if (this.missionStatus.equals(MissionStatus.ON)) this.missionStatus = MissionStatus.DONE;
        else this.missionStatus = MissionStatus.ON;
    }
}
