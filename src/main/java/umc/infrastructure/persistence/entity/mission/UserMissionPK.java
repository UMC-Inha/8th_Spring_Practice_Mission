package umc.infrastructure.persistence.entity.mission;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class UserMissionPK implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "mission_id")
    private Long missionId;
}
