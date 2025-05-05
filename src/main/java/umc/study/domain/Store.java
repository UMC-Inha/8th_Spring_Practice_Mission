package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_type_id", nullable = false)
    private FoodType foodType;

    @Column(length = 10)
    private String name;

    @Column(length = 10)
    private String address;

    private Float score;

    @Column(length = 10)
    private Float latitude;

    @Column(length = 10)
    private Float longitude;

    @Column(length = 12)
    private String contact;

}