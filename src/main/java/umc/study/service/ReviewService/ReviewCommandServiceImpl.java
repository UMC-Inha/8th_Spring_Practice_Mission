package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.ReviewImage;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.ReviewJoinDTO request) {
        Long storeId = request.getStoreId();
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store);

        List<ReviewImage> reviewImageList = request.getReviewImageList().stream()
                .map(imageUrl -> ReviewImage.builder()
                        .imageUrl(imageUrl)
                        .review(newReview)
                        .build())
                .collect(Collectors.toList());

        newReview.setReviewImageList(reviewImageList);

        return reviewRepository.save(newReview);
    }
}
