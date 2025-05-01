package umc.UMC8th.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.common.BaseEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 리뷰 제목

    @Column(precision = 2, scale = 1, nullable = false)
    private BigDecimal rating; // 리뷰 별점 (0.0 ~ 5.0)

    @Column(columnDefinition = "TEXT")
    private String reviewText; // 리뷰 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

}
