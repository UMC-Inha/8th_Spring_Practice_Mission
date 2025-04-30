package umc.study.domain.store;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.BaseTime;
import umc.study.domain.Image;
import umc.study.domain.enums.StoreStatus;
import umc.study.domain.review.Review;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false)
    private float averageRating;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "DEFAULT 'CLOSE'")
    private StoreStatus status;
}
