package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.InquiryStatus;
import umc.study.domain.enums.InquiryType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor


public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "inquiry_reply")
    private InquiryStatus inquiryReply;
    private String inquiryImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
