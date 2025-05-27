package umc.study.apiPayload.exceptition.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exceptition.GeneralException;

public class LocationHandler extends GeneralException {
    public LocationHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
