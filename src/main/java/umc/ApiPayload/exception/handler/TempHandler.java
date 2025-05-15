package umc.ApiPayload.exception.handler;

import umc.ApiPayload.code.BaseErrorCode;
import umc.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}