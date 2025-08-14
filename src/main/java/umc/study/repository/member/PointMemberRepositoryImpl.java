package umc.study.repository.member;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.enums.PointStatus;
import umc.study.domain.mapping.QPointMember;
import umc.study.domain.member.QMember;
import umc.study.domain.point.QPoint;
import umc.study.repository.member.dto.MemberInfoResponseDto;

@Repository
@RequiredArgsConstructor
public class PointMemberRepositoryImpl implements PointMemberRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberInfoResponseDto findByMemberId(Long memberId) {
        QMember member = QMember.member;
        QPointMember pointMember = QPointMember.pointMember;
        QPoint point = QPoint.point;

        return jpaQueryFactory
                .select(Projections.constructor(MemberInfoResponseDto.class,
                        point.coin.sum(),
                        member.email,
                        member.phoneNumber,
                        member.name))
                .from(member)
                .leftJoin(pointMember.member, member)
                .leftJoin(point.pointMemberList, pointMember)
                .where(
                        member.id.eq(memberId),
                        pointMember.pointStatus.eq(PointStatus.EARNED)
                )
                .groupBy(member.id, member.email, member.phoneNumber, member.name)
                .fetchOne();
    }
}

