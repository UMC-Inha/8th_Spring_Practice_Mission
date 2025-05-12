package umc.thirdParty.discord;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.config.FeignClientConfig;

@FeignClient(name = "discordApiClient", url = "https://discord.com/api/webhooks/secret/secret", configuration = FeignClientConfig.class)
public interface DiscordApiClient {

    @PostMapping
    void sendAlarmMessage(@RequestBody DiscordRequestDTO.RequestForAlarm message);
}
