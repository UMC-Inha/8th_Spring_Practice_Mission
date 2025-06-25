package umc.infrastructure.persistence.entity.user;

import lombok.Getter;

@Getter
public enum Role {
    USER("일반유저"),
    ADMIN("관리자"),
    ;


    private final String description;

    Role(String description){
        this.description = description;
    }
}
