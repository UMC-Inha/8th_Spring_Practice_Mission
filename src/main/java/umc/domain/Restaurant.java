package umc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.common.BaseEntity;

import java.awt.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private Double scoreAvg;

    private String address;

    private Point mapLocation;

    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", scoreAvg=" + scoreAvg +
                ", location=" + (location != null ? location.getName() : "N/A") + // region의 이름 출력
                '}';
    }
}
