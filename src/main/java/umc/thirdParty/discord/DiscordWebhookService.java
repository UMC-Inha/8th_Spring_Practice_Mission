package umc.thirdParty.discord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class DiscordWebhookService {

    @Autowired
    private DiscordApiClient discordApiClient;

    public void sendAlarmMessage(DiscordRequestDTO.RequestForAlarm message) {
        discordApiClient.sendAlarmMessage(message);
    }
}
