package umc.domain.store;

import jakarta.persistence.*;
import lombok.*;
import umc.domain.BaseTimeEntity;
import umc.domain.category.StoreCategory;
import umc.domain.mission.Mission;
import umc.domain.review.Review;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "store")
@Builder
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_info", nullable = false)
    private String storeInfo;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2", nullable = false)
    private String addressLine2;

    @Column(name = "location", nullable = false)
    private String location;

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StoreCategory> storeCategories = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StoreImage> storeImages = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mission> missions = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();
}
