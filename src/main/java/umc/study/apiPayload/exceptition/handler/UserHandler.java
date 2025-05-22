package umc.study.apiPayload.exceptition.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exceptition.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
