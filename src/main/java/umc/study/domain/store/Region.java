package umc.study.domain.store;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_code")
    private String regionCode;
    private String name;
    private String city;
    private String district;
    private String neighborhood;
    private Double latitude;
    private Double longitude;
}