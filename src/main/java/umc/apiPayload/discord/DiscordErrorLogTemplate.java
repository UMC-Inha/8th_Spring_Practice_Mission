package umc.apiPayload.discord;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DiscordErrorLogTemplate {

	INTERNAL_SERVER_ERROR(
		"""
		❗ **[500 Internal Server Error]**
		📅 발생 시각: ${timestamp}
		🌐 요청 URL: ${requestUrl}
		📄 예외 메시지:
		```
		${exceptionMessage}
		```
		"""
	);

	private final String template;
}
