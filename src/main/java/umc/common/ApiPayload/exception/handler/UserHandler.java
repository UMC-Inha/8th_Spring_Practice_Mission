package umc.common.ApiPayload.exception.handler;

import umc.common.ApiPayload.code.BaseErrorCode;
import umc.common.ApiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
   public UserHandler(BaseErrorCode errorCode) {
      super(errorCode);
   }
}
