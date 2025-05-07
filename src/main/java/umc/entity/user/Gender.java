package umc.entity.user;

import lombok.Getter;

@Getter
public enum Gender {
    W("여성"),
    M("남성"),
    ;

    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
