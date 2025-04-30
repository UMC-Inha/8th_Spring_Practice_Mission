package umc.Entity.category;

import jakarta.persistence.*;
import lombok.*;
import umc.Entity.user.User;

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
}
