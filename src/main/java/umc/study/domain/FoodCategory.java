package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.UserPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class FoodCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    /*@Builder.Default
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.PERSIST)
    private List<Store> storeList = new ArrayList<>();
    */

    @Builder.Default
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<UserPrefer> foodPreferenceList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.PERSIST)
    private List<Mission> missionList = new ArrayList<>();
}
