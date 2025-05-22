package umc.study.apiPayload.exceptition.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exceptition.GeneralException;

public class MissionHandler extends GeneralException {
    MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
