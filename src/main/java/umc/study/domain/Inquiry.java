package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.InquiryStatus;
import umc.study.domain.enums.InquiryType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //사용자 id, 답변 id

    @Enumerated(EnumType.STRING)
    private InquiryStatus status;

    private String title;

    @Enumerated(EnumType.STRING)
    private InquiryType inquiryType;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String url;
}
