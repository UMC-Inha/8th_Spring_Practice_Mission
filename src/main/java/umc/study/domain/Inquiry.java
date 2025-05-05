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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'NOT_YET'")
    private InquiryStatus status;

    @Column(length = 10)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private InquiryType inquiryType;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(length = 30)
    private String url;
}
