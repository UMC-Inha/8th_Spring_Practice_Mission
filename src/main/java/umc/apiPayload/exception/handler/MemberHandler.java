package umc.apiPayload.exception.handler;

import umc.apiPayload.code.BaseErrorCode;
import umc.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
