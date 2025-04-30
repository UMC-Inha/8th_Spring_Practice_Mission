package umc.Entity.category;

import jakarta.persistence.*;
import lombok.*;
import umc.Entity.store.Store;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="store_category")
@Builder
public class StoreCategory {

    @EmbeddedId
    private StoreCategoryPK id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("storeId")                       // id.storeId 컬럼과 매핑
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("categoryId")                    // id.categoryId 컬럼과 매핑
    @JoinColumn(name = "category_id")
    private Category category;
}
