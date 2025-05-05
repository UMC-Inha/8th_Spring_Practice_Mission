package umc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlarmType {
    REVIEW("리뷰"),
    MISSION("미션");

    private final String description;
}
