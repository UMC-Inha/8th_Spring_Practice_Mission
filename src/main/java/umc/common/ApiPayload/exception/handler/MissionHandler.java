package umc.common.ApiPayload.exception.handler;

import umc.common.ApiPayload.code.BaseErrorCode;
import umc.common.ApiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
