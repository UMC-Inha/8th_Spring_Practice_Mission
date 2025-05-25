package umc.spring.apiPayload.Exception.handler;

import umc.spring.apiPayload.Exception.GeneralException;
import umc.spring.apiPayload.code.BaseErrorCode;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
