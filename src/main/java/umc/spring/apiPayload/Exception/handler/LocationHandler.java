package umc.spring.apiPayload.Exception.handler;

import umc.spring.apiPayload.Exception.GeneralException;
import umc.spring.apiPayload.code.BaseErrorCode;

public class LocationHandler extends GeneralException {
    public LocationHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}