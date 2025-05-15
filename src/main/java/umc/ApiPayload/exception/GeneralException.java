package umc.ApiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.ApiPayload.code.BaseErrorCode;
import umc.ApiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}