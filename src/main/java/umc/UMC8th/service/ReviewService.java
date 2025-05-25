package umc.UMC8th.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.CreateReviewRequest;
import umc.UMC8th.repository.MemberRepository;
import umc.UMC8th.repository.ReviewRepository;
import umc.UMC8th.repository.StoreRepository.StoreRepository;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    public Review createReview(CreateReviewRequest request) {
        Member member = memberRepository.findById(1L) // 하드코딩으로 하기
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));
        Store store = storeRepository.findById(1L) // 하드코딩으로 하기
                .orElseThrow(() -> new RuntimeException("존재하지 않는 가게"));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .reviewText(request.getReviewText())
                .rating(request.getRating())
                .build();

        return reviewRepository.save(review);
    }
}
