package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDto;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 공통응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE4001", "잘못된 페이지 요청 번호로, 페이지 값은 1 이상이어야 합니다."),
    INVALID_PAGE_FORMAT(HttpStatus.BAD_REQUEST, "PAGE4002", "잘못된 페이지 요청 형식입니다."),

    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 가게 관련 에러
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "존재하지 않는 가게입니다."),
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "존재하지 않는 지역입니다."),

    //미션 관련 에러
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "존재하지 않는 미션입니다,"),
    DUPLICATE_CHALLENGE(HttpStatus.BAD_REQUEST, "MISSION4002", "이미 도전 중인 미션입니다."),
    USER_MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST,"MISSION4003", "사용자의 미션을 찾을 수 없습니다."),

    // 음식 카테고리 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4001", "음식 카테고리가 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}