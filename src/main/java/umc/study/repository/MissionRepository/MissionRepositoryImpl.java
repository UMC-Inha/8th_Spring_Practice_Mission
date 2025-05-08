package umc.study.repository.MissionRepository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.QRegion;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;
import umc.study.dto.MemberMissionDto;
import umc.study.dto.RegionMissionDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission qMission = QMission.mission;
    private final QMemberMission qMemberMission = QMemberMission.memberMission;
    private final QStore qStore = QStore.store;
    private final QRegion qRegion = QRegion.region;

    @Override
    public Page<MemberMissionDto> findByMemberAndStatus(
            Long memberId,
            MissionStatus status,
            Pageable pageable
    ) {
        QueryResults<MemberMissionDto> qr = jpaQueryFactory
                .select(Projections.constructor(
                        MemberMissionDto.class,
                        qMission.id,
                        qMission.missionSpec,
                        qMission.reward,
                        qMission.deadline,
                        qMission.store.name,
                        qMemberMission.status.stringValue()
                ))
                .from(qMemberMission)
                .join(qMemberMission.mission, qMission)
                .join(qMission.store, qStore)
                .where(qMemberMission.member.id.eq(memberId)
                        .and(qMemberMission.status.eq(status)))
                .orderBy(qMission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<MemberMissionDto> content = qr.getResults();
        long total = qr.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    public Page<RegionMissionDto> findByRegion(Long regionId, Pageable pageable) {
        QueryResults<RegionMissionDto> qr;
        qr = jpaQueryFactory
                .select(Projections.constructor(
                        RegionMissionDto.class,
                        qMission.id,
                        qMission.missionSpec,
                        qMission.reward,
                        qMission.deadline,
                        qStore.name
                ))
                .from(qMission)
                .join(qMission.store, qStore)
                .join(qStore.region, qRegion)
                .where(qRegion.id.eq(regionId))
                .orderBy(qMission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<RegionMissionDto> content = qr.getResults();
        long total = qr.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
