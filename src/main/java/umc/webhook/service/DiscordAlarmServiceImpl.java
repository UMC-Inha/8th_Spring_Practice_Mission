package umc.webhook.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import umc.webhook.DiscordMessage;
import umc.webhook.client.DiscordClient;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscordAlarmServiceImpl implements DiscordAlarmService {
    private final DiscordClient discordClient;

    @Override
    public void notify(Exception e, WebRequest request) {
        DiscordMessage msg = createMessage(e, request);
        discordClient.sendAlarm(msg);
    }


    private DiscordMessage createMessage(Exception e, WebRequest request) {
        return DiscordMessage.builder()
                .content("# 🚨 에러 발생 비이이이이사아아아앙")
                .embeds(
                        List.of(
                                DiscordMessage.Embed.builder()
                                        .title("ℹ️ 에러 정보")
                                        .description(
                                                "### 🕖 발생 시간\n"
                                                        + LocalDateTime.now()
                                                        + "\n"
                                                        + "### 🔗 요청 URL\n"
                                                        + createRequestFullPath(request)
                                                        + "\n"
                                                        + "### 📄 Stack Trace\n"
                                                        + "```\n"
                                                        + getStackTrace(e).substring(0, 1000)
                                                        + "\n```")
                                        .build()
                        )
                )
                .build();
    }

    private String createRequestFullPath(WebRequest webRequest) {
        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        String fullPath = request.getMethod() + " " + request.getRequestURL();

        String queryString = request.getQueryString();
        if (queryString != null) {
            fullPath += "?" + queryString;
        }

        return fullPath;
    }

    private String getStackTrace(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
