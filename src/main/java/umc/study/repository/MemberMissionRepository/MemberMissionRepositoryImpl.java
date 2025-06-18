package umc.study.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;
import umc.study.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<MemberMissionResponseDTO.MyMemberMissionDTO> findMyMissionsDTOByCursor(
            Long memberId,
            MissionStatus status,
            Long cursorId,
            LocalDateTime cursorCreatedAt,
            Integer size
    ) {
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(status));

        if (cursorCreatedAt != null && cursorId != null) {
            predicate.and(
                    memberMission.createdAt.lt(cursorCreatedAt)
                            .or(
                                    memberMission.createdAt.eq(cursorCreatedAt)
                                            .and(memberMission.id.lt(cursorId))
                            )
            );
        }

        return queryFactory
                .select(Projections.constructor(MemberMissionResponseDTO.MyMemberMissionDTO.class,
                        memberMission.id,
                        store.name,
                        mission.missionSpec,
                        mission.reward,
                        memberMission.status,
                        memberMission.createdAt
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(predicate)
                .orderBy(memberMission.createdAt.desc(), memberMission.id.desc())
                .limit(size + 1)
                .fetch();
    }

}
