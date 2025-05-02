package umc.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.domain.CuisineType;
import umc.domain.PriceRange;
import umc.domain.User;
import umc.domain.VisitPurpose;
import umc.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPreference extends BaseEntity {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY) // FK를 갖고 있으므로 연관관계의 주인
    @JoinColumn(name = "cuisine_type")
    private CuisineType cuisineType;

    @OneToOne(fetch = FetchType.LAZY) // FK를 갖고 있으므로 연관관계의 주인
    @JoinColumn(name = "price_range")
    private PriceRange priceRange;

    @OneToOne(fetch = FetchType.LAZY) // FK를 갖고 있으므로 연관관계의 주인
    @JoinColumn(name = "visit_purpose")
    private VisitPurpose visitPurpose;

}
