package umc.spring.apiPayload.Exception.handler;

import umc.spring.apiPayload.Exception.GeneralException;
import umc.spring.apiPayload.code.BaseErrorCode;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}