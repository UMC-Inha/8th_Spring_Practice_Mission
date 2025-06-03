package umc.study.service.review;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;
import umc.study.domain.user.User;
import umc.study.repository.review.ReviewRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.repository.user.UserRepository;
import umc.study.web.dto.request.ReviewRequestDto;
import umc.study.web.dto.response.ReviewResponseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review registerReview(ReviewRequestDto.RegisterDto request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Review newReview = ReviewConverter.toReview(request, user, store);
        Review savedReview = reviewRepository.save(newReview);
        updateStoreAverageRate(store); // 사용자가 새롭게 평점 입력하면, store 평점이 업데이트 되어야함.
        return savedReview;
    }

    @Override
    public Slice<Review> findUserReviewList(Long userId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return reviewRepository.findByUserId(userId, pageable);
    }

    private void updateStoreAverageRate(Store store) {
        List<Review> reviews = reviewRepository.findAllByStore(store);
        BigDecimal avg = reviews.stream()
                .map(Review::getScore)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(reviews.size()), 2, RoundingMode.HALF_UP);

        store.setAverageRate(avg);
        storeRepository.save(store);
    }
}
