package umc.study.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;
import umc.study.dto.MemberMissionDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission qMission = QMission.mission;
    private final QMemberMission qMemberMission = QMemberMission.memberMission;

    public List<MemberMissionDto> findByMemberAndStatus(Long memberId, MissionStatus status) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberMissionDto.class,
                        qMission.id,
                        qMission.missionSpec,
                        qMission.reward,
                        qMission.deadline,
                        qMission.store.name,
                        qMemberMission.status.stringValue()
                ))
                .from(qMission)
                .join(qMemberMission, qMemberMission)
                .where(qMemberMission.member.id.eq(memberId)
                        .and(qMemberMission.status.eq(status)))
                .orderBy(qMission.deadline.asc())
                .fetch();
    }
}
