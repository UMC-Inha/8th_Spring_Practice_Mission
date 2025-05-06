package umc.study.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InquiryStatus {
    PENDING("답변 대기중"),
    ANSWERED("답변 완료"),
    CLOSED("종료됨");

    private final String description;
}