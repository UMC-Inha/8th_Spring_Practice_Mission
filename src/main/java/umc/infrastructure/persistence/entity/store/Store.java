package umc.infrastructure.persistence.entity.store;

import jakarta.persistence.*;
import lombok.*;
import umc.infrastructure.persistence.entity.BaseTimeEntity;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.category.StoreCategory;
import umc.infrastructure.persistence.entity.mission.Mission;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "store")
@Builder
@Setter
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "store_name", nullable = false, length = 50)
    private String storeName;

    @Column(name = "store_info", nullable = false, columnDefinition = "TEXT")
    private String storeInfo;

    @Column(name = "address", nullable = false, length = 255)
    private String address;


    @Column(name = "location", nullable = false, length = 20)
    private String location;

    @Builder.Default
    @Column(nullable = false)
    private Float score = 0.0f;

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreCategory> storeCategories = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreImage> storeImages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
