package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ReviewQueryService {
    Page<Review> findReview(long id);

    List<Review> findReviewsByStore(long id);

    Review insertReview(Long userId, Long storeId, String content, BigDecimal rating);
}
