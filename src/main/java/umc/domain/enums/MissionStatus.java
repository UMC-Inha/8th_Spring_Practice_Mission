package umc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MissionStatus {
	CHALLENGING("도전중"),
	COMPLETED("미션완료");

	private final String description;
}
