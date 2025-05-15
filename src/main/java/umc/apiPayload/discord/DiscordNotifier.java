package umc.apiPayload.discord;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DiscordNotifier {

	@Value("${discord.webhook.url}")
	private String discordWebhookUrl;
	private final RestTemplate restTemplate = new RestTemplate();

	public void sendNotification(String timeStamp, String exceptionMessage, String requestUrl) {
		// 1. 템플릿 바인딩 파라미터 설정
		Map<String, String> parameters = Map.of("timestamp", timeStamp, "requestUrl", requestUrl, "exceptionMessage", exceptionMessage);
		// 2. 템플릿 양식과 파라미터로 디스코드 전송
		sendDiscordMessage(DiscordErrorLogTemplate.INTERNAL_SERVER_ERROR.getTemplate(), parameters);
	}

	private void sendDiscordMessage(String template, Map<String, String> parameters) {

		// 1. 템플릿에 파라미터 바인딩
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			template = template.replace("${" + entry.getKey() + "}", entry.getValue());
		}
		Map<String, String> body = Map.of("content", template);

		// 2. 디스코드로 post 요청
		restTemplate.postForEntity(discordWebhookUrl, body, String.class);
	}
}
