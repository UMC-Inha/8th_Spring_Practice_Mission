package umc.study.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlarmType {
    SYSTEM("시스템 알림"),
    MISSION_UPDATE("미션 업데이트"),
    REVIEW_RESPONSE("리뷰 답변"),
    EVENT("이벤트 알림");

    private final String description;
}