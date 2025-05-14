package umc.study.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InquiryType {
    STORE_ISSUE("가게 문의"),
    APP_ERROR("앱 오류 신고"),
    ACCOUNT_QUESTION("계정 문의"),
    ETC("기타 문의");

    private final String description;
}