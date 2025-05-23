package umc.common.ApiPayload.exception.handler;

import umc.common.ApiPayload.code.BaseErrorCode;
import umc.common.ApiPayload.exception.GeneralException;

public class CategoryHandler extends GeneralException {
    public CategoryHandler(BaseErrorCode errorCode) {super (errorCode);}
}
