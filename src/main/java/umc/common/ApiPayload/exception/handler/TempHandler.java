package umc.common.ApiPayload.exception.handler;

import umc.common.ApiPayload.code.BaseErrorCode;
import umc.common.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}