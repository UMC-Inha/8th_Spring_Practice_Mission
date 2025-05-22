package umc.study.apiPayload.exceptition.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exceptition.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
