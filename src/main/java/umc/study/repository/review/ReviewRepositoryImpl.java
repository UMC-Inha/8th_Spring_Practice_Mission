package umc.study.repository.review;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.Member;
import umc.study.domain.member.QMember;
import umc.study.domain.review.Review;
import umc.study.domain.store.QStore;
import umc.study.domain.store.Store;
import umc.study.repository.review.dto.ReviewSaveRequestDto;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private EntityManager entityManager;

    @Override
    @Transactional
    public Review saveReviewByMemberIdAndStoreId(ReviewSaveRequestDto requestDto) {
        QStore qStore = QStore.store;
        QMember qMember = QMember.member;

        Store store = queryFactory
                .selectFrom(qStore)
                .where(qStore.id.eq(requestDto.getStoreId()))
                .fetchOne();
        Member member = queryFactory
                .selectFrom(qMember)
                .where(qMember.id.eq(requestDto.getMemberId()))
                .fetchOne();

        Review review = Review.builder()
                .body(requestDto.getBody())
                .score(requestDto.getScore())
                .imageList(requestDto.getImageList())
                .build();

        entityManager.persist(review);
        return review;
    }
}
