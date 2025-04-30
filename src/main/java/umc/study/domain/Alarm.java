package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.UserAlarm;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Alarm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /*@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlarmType type;*/

    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<UserAlarm> memberAlarmList = new ArrayList<>();
}
