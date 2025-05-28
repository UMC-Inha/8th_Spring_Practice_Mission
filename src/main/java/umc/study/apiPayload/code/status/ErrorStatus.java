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
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // 음식 타입 에러
    FOOD_TYPE_NOT_FOUND(HttpStatus.NOT_FOUND, "FOODTYPE4001", "음식 타입을 찾을 수 없습니다."),

    // 가게 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "가게 정보를 찾을 수 없습니다."),

    //미션 에러
    ALREADY_MISSION_CHALLENGE(HttpStatus.CONFLICT, "MISSION4001", "이미 도전 중인 미션입니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4002", "미션을 찾을 수 없습니다."),

    //페이징 에러
    PAGE_INVALID_TYPE(HttpStatus.BAD_REQUEST, "PAGE4001", "page 파라미터는 숫자여야 합니다."),
    PAGE_NOT_POSITIVE(HttpStatus.BAD_REQUEST, "PAGE4002", "page는 1 이상의 양수여야 합니다.");

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
                .build()
                ;
    }
}
