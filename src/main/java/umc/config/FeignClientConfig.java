package umc.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() throws JsonProcessingException {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json; charset=utf-8");
        };
    }
}
