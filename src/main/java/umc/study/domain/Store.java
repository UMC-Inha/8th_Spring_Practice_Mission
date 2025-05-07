package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
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

    private BigDecimal score;

    @Column(length = 10)
    private Double latitude;

    @Column(length = 10)
    private Double longitude;

    @Column(length = 12)
    private String contact;

}