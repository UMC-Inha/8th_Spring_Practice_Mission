package umc.UMC8th.exception.handler;

import umc.UMC8th.apiPayload.code.BaseErrorCode;
import umc.UMC8th.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
