package umc.study.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exceptition.GeneralException;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("남자"),
    FEMALE("여자"),
    NONE("선택 안함");

    private final String description;

    @JsonCreator
    public static Gender from(String value) {
        if (value == null) {
            return null;
        }
        
        // Enum 이름으로 매칭 (MALE, FEMALE, NONE)
        for (Gender gender : Gender.values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        
        // Description으로 매칭 (남자, 여자, 선택 안함)
        for (Gender gender : Gender.values()) {
            if (gender.description.equals(value)) {
                return gender;
            }
        }
        
        throw new GeneralException(ErrorStatus.INVALID_GENDER);
    }

    public static Gender fromDescription(String description) {
        for (Gender gender : Gender.values()) {
            if (gender.description.equals(description)) {
                return gender;
            }
        }
        throw new GeneralException(ErrorStatus.INVALID_GENDER);
    }

    @JsonValue
    public String getName() {
        return name();
    }
}

