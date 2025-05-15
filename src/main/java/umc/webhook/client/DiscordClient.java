package umc.webhook.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.config.DiscordFeignConfiguration;
import umc.webhook.DiscordMessage;


@FeignClient(
        name = "discord-client",
        url = "https://discord.com/api/webhooks/1372426896414871593/ybJluhcJvibJ2vmmEL4yt5AYjYsa905nadMnfRznuhwG-I93LlZUhu0OQn3T8HY5dJmv",
        configuration = DiscordFeignConfiguration.class)
public interface DiscordClient {

    @PostMapping()
    void sendAlarm(@RequestBody DiscordMessage message);
}
