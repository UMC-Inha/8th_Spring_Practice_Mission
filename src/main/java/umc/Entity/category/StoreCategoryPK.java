package umc.Entity.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class StoreCategoryPK implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "category_id")
    private Long categoryId;
}