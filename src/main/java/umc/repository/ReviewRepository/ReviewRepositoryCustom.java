package umc.repository.ReviewRepository;

public interface ReviewRepositoryCustom {

	Long insertReview(Long userId, Long restaurantId, String content, Integer score);
}