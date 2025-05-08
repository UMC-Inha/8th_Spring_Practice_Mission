package umc.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;
import umc.domain.QReview;

@AllArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	private final QReview review = QReview.review;

	@Override
	public Long insertReview(Long userId, Long restaurantId, String content, Integer score) {

		return jpaQueryFactory
			.insert(review)
			.columns(review.user, review.restaurant, review.content, review.score)
			.values(userId, restaurantId, content, score)
			.execute();
	}
}
