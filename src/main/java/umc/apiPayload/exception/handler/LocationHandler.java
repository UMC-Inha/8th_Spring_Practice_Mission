package umc.apiPayload.exception.handler;

import umc.apiPayload.code.BaseErrorCode;
import umc.apiPayload.exception.GeneralException;

public class LocationHandler extends GeneralException {

    public LocationHandler(BaseErrorCode code) {
        super(code);
    }
}
