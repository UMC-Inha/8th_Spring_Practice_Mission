package umc.presentation.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {
    public static <T>ResponseEntity <T> buildResponseEntityWithStatus(T body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }

    public static <T>ResponseEntity<T> buildDefaultResponseEntity(T body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<Void> buildSimpleResponseEntity() {
        return ResponseEntity.ok().build();
    }
}
