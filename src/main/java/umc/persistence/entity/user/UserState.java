package umc.persistence.entity.user;

import lombok.Getter;

@Getter
public enum UserState {
    ACTIVE("활성회원"),
    INACTIVE("비활성회원"),
    ;

    private final String description;

    UserState(String description) {
        this.description = description;
    }
}
