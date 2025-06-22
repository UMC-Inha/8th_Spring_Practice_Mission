package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "server error. ask to manager."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","wrong request"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","auth required"),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "banned request"),


    // 멤버 관려 에러
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4001", "no user found."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "USER4002", "nickname is required."),
    INVALID_GENDER(HttpStatus.BAD_REQUEST, "USER4003", "Invalid gender."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "USER4003", "password is incorrect."),
    DUPLICATE_JOIN_REQUEST(HttpStatus.BAD_REQUEST, "USER4004", "already exists with the same email address."),

    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "USER4005", "Invalid token."),

    // 게시글 에러
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "no articles."),

    // 음식 카테고리 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4005", "food category not found."),

    // 지역 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "region not found."),

    // 식당 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "store not found."),

    // 미션 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "mission not found."),
    MISSION_ALREADY_DONE(HttpStatus.BAD_REQUEST, "MISSION4002", "already completed mission."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001","this is test");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
