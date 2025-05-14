package umc.UMC8th.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.UMC8th.apiPayload.code.BaseErrorCode;
import umc.UMC8th.apiPayload.code.ErrorReasonDTO;

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
