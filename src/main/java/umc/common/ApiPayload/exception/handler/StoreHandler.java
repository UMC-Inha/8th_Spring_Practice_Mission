package umc.common.ApiPayload.exception.handler;

import umc.common.ApiPayload.code.BaseErrorCode;
import umc.common.ApiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {super (errorCode);}

}
