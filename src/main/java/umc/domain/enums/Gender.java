package umc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("남성"),
    FEMALE("여성"),
    NONE("비공개");

    private final String description;
}
