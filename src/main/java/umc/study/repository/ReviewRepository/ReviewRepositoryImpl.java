package umc.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QReview;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;

    //리뷰 작성 및 저장
    @Override
    public Long save(User user, Store store, String content, BigDecimal rating) {
        return queryFactory
                .insert(review)
                .columns(review.user, review.store, review.content, review.rating)
                .values(user, store, content, rating)
                .execute();
    }
}
