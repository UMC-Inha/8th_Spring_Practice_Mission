package umc.UMC8th.exception.handler;

import umc.UMC8th.apiPayload.code.BaseErrorCode;
import umc.UMC8th.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
