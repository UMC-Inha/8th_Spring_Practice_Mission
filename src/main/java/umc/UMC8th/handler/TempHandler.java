package umc.UMC8th.handler;

import umc.UMC8th.apiPayload.code.BaseErrorCode;
import umc.UMC8th.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
