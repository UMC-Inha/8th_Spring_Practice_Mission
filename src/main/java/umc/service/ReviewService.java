package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.ReviewImgRepository;
import umc.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewImgRepository reviewImgRepository;

    private final AnswerService answerService;

    @Transactional
    public void deleteReviewByMember(Long memberId) {

        List<Long> reviewIdList = reviewRepository.findAllReviewIdsByMemberId(memberId);

        answerService.deleteAnswerByReview(reviewIdList);
        reviewImgRepository.deleteAllByReviewIds(reviewIdList);
        reviewRepository.deleteAllByReviewIds(reviewIdList);
    }
}
