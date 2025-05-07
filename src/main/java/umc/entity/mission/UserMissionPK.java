package umc.entity.mission;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserMissionPK implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "mission_id")
    private Long missionId;
}
