package umc.study.apiPayload.exceptition.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exceptition.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
