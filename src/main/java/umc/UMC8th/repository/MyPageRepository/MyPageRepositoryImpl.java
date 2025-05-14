package umc.UMC8th.repository.MyPageRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.UMC8th.domain.QInquiryNotification;
import umc.UMC8th.domain.QMember;
import umc.UMC8th.domain.QNotification;
import umc.UMC8th.domain.QReview;
import umc.UMC8th.domain.mapping.QMemberMission;
import umc.UMC8th.dto.InquiryResponse;
import umc.UMC8th.dto.MyPageUserInfoResponse;
import umc.UMC8th.dto.NotificationResponse;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyPageRepositoryImpl implements MyPageRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MyPageUserInfoResponse getUserInfo(Long memberId) {
        QMember member = QMember.member;
        QReview review = QReview.review;
        QMemberMission memberMission = QMemberMission.memberMission;

        return queryFactory
                .select(Projections.constructor(MyPageUserInfoResponse.class,
                        member.id,
                        member.name,
                        member.email,
                        member.phoneNumber,
                        member.status.stringValue().eq("ACTIVE"),
                        member.points,
                        memberMission.mission.rewardPoints.sum().coalesce(0),
                        review.id.count().coalesce(0L)
                ))
                .from(member)
                .leftJoin(memberMission).on(memberMission.member.eq(member).and(memberMission.completedDate.isNotNull())) // 완료된 미션만 조인
                .leftJoin(review).on(review.member.eq(member)) // 리뷰 조인
                .where(member.id.eq(memberId))
                .groupBy(member.id) // count,sum 사용하니깐 groupBy 사용
                .fetchOne();
    }

    @Override
    public List<InquiryResponse> getUserInquiries(Long memberId) {
        QInquiryNotification inquiry = QInquiryNotification.inquiryNotification;

        return queryFactory
                .select(Projections.constructor(InquiryResponse.class,
                        inquiry.id,
                        inquiry.notification.id,
                        inquiry.inquiryTitle,
                        inquiry.inquiryContent,
                        inquiry.createdAt
                ))
                .from(inquiry)
                .where(inquiry.member.id.eq(memberId)) // 해당 id의 유저만
                .orderBy(inquiry.createdAt.desc()) // 최신순으로 정렬
                .fetch();
    }

    @Override
    public List<NotificationResponse> getUserNotifications(Long memberId) {
        QNotification notification = QNotification.notification;

        return queryFactory
                .select(Projections.constructor(NotificationResponse.class,
                        notification.id,
                        notification.message,
                        notification.status.stringValue(),
                        notification.createdAt,
                        notification.updatedAt
                ))
                .from(notification)
                .where(notification.member.id.eq(memberId))
                .orderBy(notification.createdAt.desc())
                .fetch();
    }
}
