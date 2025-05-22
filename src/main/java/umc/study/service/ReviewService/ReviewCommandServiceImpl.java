package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.ReviewPicture;
import umc.study.domain.Store;
import umc.study.repository.ReviewPictureRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.request.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final ReviewPictureRepository reviewPictureRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review save(Long storeId, ReviewRequestDTO.createReviewDto request) {
        Store store = storeRepository.getReferenceById(storeId);

        Review review = ReviewConverter.toReview(store, request);
        reviewRepository.save(review);

        List<ReviewPicture> pictures = ReviewConverter.toReviewPictures(request.getImageUrls(), review);
        reviewPictureRepository.saveAll(pictures);

        return review;
    }
}
