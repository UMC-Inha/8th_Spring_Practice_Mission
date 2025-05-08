package umc.repository.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.entity.review.Review;
import umc.entity.user.User;
import umc.repository.mission.JpaMissionRepository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository{
    private final JpaReviewRepository jpaReviewRepository;
}
