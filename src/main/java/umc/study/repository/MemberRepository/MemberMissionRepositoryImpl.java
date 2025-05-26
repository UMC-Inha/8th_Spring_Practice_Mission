package umc.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.QMission;
import umc.study.domain.mapping.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;
    private final QMemberMission qMemberMission = QMemberMission.memberMission;
    private final QMission qMission = QMission.mission;
}
