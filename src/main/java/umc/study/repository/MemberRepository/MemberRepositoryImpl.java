package umc.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.web.dto.MemberDetailResponseDto;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;

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


}
