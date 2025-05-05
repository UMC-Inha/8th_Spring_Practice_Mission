package umc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocialType {
    KAKAO("카카오"),
    GOOGLE("구글"),
    NAVER("네이버"),
    APPLE("애플");

    private final String description;
}
