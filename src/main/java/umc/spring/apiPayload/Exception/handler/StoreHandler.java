package umc.spring.apiPayload.Exception.handler;

import umc.spring.apiPayload.Exception.GeneralException;
import umc.spring.apiPayload.code.BaseErrorCode;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
