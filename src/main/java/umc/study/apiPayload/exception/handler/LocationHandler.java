package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class LocationHandler extends GeneralException {
    public LocationHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
