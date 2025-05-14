package umc.study.apiPayload.code;

import java.awt.desktop.UserSessionEvent;

public interface BaseCode{
    UserSessionEvent.Reason getReason();
    UserSessionEvent.Reason getReasonHttpStatus();
}
