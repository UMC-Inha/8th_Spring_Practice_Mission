package umc.apiPayload.exception.handler;

import umc.apiPayload.code.BaseErrorCode;
import umc.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
