package umc.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.Member.MemberDetailResponseDto;

import java.util.List;

import static umc.study.domain.QMember.member;
import static umc.study.domain.mapping.QMemberMission.memberMission;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = member;

    @Override
    public MemberDetailResponseDto findMemberDetail(Long memberId) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberDetailResponseDto.class,
                        qMember.id,
                        qMember.name,
                        qMember.email,
                        qMember.profileImageUrl,
                        qMember.phoneVerified,
                        qMember.phoneNumber,
                        qMember.point
                ))
                .from(qMember)
                .fetchOne();
    }

    @Override
    public Page<MemberMission> findMissionsByMember(
            Long memberId,
            Pageable pageable
    ) {
        List<MemberMission> content = jpaQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.member).fetchJoin()
                .where(
                        memberMission.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.CHALLENGING)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberMission.id.asc())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .join(memberMission.member)
                .where(
                        member.id.eq(memberId)
                )
                .fetchOne();

        long total = (totalCount != null ? totalCount : 0L);

        return new PageImpl<>(content, pageable, total);
    }
}
