package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.store.FoodCategory;
import umc.study.domain.user.User;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
// @Setter 지양 : 객체지향 설계 핵심 원칙인 불변성과 관련된 문제
// setter 최소화하고 생성자나 빌더로만 값을 설정하는 의미.
public class PreferFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private FoodCategory category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void setMember(User user){
        if(this.user != null)
            user.getPreferFoods().remove(this);
        this.user = user;
        user.getPreferFoods().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.category = foodCategory;
    }
}
