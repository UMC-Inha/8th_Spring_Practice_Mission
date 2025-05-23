package umc.infrastructure.persistence.entity.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserCategoryPK implements Serializable {

    @Setter
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category_id")
    private Long categoryId;
}