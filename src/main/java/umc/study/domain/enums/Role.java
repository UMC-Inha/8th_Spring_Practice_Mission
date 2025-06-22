package umc.study.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN, USER;
    
    @JsonCreator
    public static Role from(String value) {
        if (value == null) {
            return null;
        }
        
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        
        throw new IllegalArgumentException("Invalid role: " + value);
    }
    
    @JsonValue
    public String getName() {
        return name();
    }
}
