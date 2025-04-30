package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Alarm;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.AlarmStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAlarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AlarmStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Alarm alarm;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
