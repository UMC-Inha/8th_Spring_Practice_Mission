package umc.application.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.ReviewConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.StoreHandler;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.review.ReviewRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;
import umc.presentation.dto.review.ReviewRequestDto;
import umc.presentation.dto.review.ReviewResponseDto;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public ReviewResponseDto.CreateReviewResponseDto createReview(ReviewRequestDto.CreateReviewRequestDto request){
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Store store = storeRepository.findById(request.storeId()).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review review = ReviewConverter.toReview(request);

        review.changeStore(store);
        review.changeUser(user);

        return ReviewConverter.toCreateReviewResponseDto(reviewRepository.save(review));
    }
}
