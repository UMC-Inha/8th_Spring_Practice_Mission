package umc.service.review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.apiPayload.exception.handler.LocationHandler;
import umc.converter.RestaurantConverter;
import umc.converter.ReviewConverter;
import umc.domain.*;
import umc.repository.restaurant.RestaurantRepository;
import umc.repository.review.ReviewImageRepository;
import umc.repository.review.ReviewRepository;
import umc.repository.user.UserRepository;
import umc.web.dto.review.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;

    private final RestaurantRepository restaurantRepository;

    private final UserRepository userRepository;

    @Override
    public void createReview(ReviewRequestDTO.createReviewDTO request, Long restaurantId) {

        // @Validated로 앞에서 미리 유효성 검사 진행
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND)
        );

        // TODO 하드 코딩한 값으로 추후, 값 변경하기
        User user = userRepository.findById(1L).orElseThrow(
                () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );
        Review review = ReviewConverter.toReview(request, restaurant, user);

        reviewRepository.save(review);

        // imageList -> RestaurantImage 리스트 변환
        List<ReviewImage> images = request.getImageList().stream()
                .map(image -> ReviewImage.builder()
                        .review(review)
                        .image(image)
                        .build()
                )
                .collect(Collectors.toList());

        // 한 번에 저장
        reviewImageRepository.saveAll(images);
    }
}
