package umc.domain.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
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
public class StoreCategoryId implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "category_id")
    private Long categoryId;
}