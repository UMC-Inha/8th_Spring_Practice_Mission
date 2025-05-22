package umc.infrastructure.persistence.entity.category;

import jakarta.persistence.*;
import lombok.*;
import umc.infrastructure.persistence.entity.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="user_category")
@Builder
public class UserCategory {

    @EmbeddedId
    private UserCategoryPK id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("userId")                       // id.storeId 컬럼과 매핑
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("categoryId")                    // id.categoryId 컬럼과 매핑
    @JoinColumn(name = "category_id")
    private Category category;

    public void setUser(User user){
        if(this.user != null)
            user.getUserCategories().remove(this);
        this.user = user;
        user.getUserCategories().add(this);
    }

    public void setFoodCategory(Category foodCategory){
        this.category = foodCategory;
    }
}
