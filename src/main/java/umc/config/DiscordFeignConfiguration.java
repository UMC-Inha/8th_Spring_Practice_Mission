package umc.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordFeignConfiguration {

    // 예: 공통 헤더 세팅
    @Bean
    public RequestInterceptor discordInterceptor() {
        return template -> {
            template.header("Content-Type", "application/json");

        };
    }
}
