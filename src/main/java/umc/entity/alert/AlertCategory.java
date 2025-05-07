package umc.entity.alert;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "alert_category")
@Entity
public class AlertCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "alert_category_name", nullable = false)
    private String alertCategoryName;

    @Builder.Default
    @OneToMany(mappedBy = "alertCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Alert> alerts = new HashSet<>();
}