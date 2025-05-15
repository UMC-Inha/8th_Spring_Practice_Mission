package umc.webhook.service;

import org.springframework.web.context.request.WebRequest;

public interface DiscordAlarmService {

    void notify(Exception e, WebRequest request);
}
