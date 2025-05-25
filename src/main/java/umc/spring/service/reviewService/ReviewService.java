package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.MemberHandler;
import umc.spring.apiPayload.Exception.handler.StoreHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.web.dto.review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Review writeReview(ReviewRequestDTO.CreateReviewDTO request, Long storeId) {

        Store findStore = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.Store_NOT_FOUND));

        Member findMember = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, findStore, findMember);

        reviewRepository.save(newReview);

        return newReview;
    }
}
