package umc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.common.BaseEntity;
import umc.domain.enums.DayOfWeek;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenHours extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "open_hours_id")
    private Long id;

    private String totalRunningTime;

    private String breakTime;

    private DayOfWeek dayOfWeek;
}
