package umc.UMC8th.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.FoodCategories;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    // 유저 선호 음식 관련
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_categories_id")
    private FoodCategories foodCategories;



}
