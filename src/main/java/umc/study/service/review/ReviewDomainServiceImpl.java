package umc.study.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.review.Review;
import umc.study.repository.review.ReviewRepositoryImpl;
import umc.study.repository.review.dto.ReviewSaveResponseDto;
import umc.study.repository.review.dto.ReviewSaveRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewDomainServiceImpl implements ReviewDomainService {

    private final ReviewRepositoryImpl reviewRepository;

    @Override
    public ReviewSaveResponseDto saveReview(ReviewSaveRequestDto reviewRequestDto) {
        Review review = reviewRepository.saveReviewByMemberIdAndStoreId(reviewRequestDto);
        return ReviewSaveResponseDto.EntityToDto(review);
    }

}
