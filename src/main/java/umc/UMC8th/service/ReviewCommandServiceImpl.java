package umc.UMC8th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.converter.ReviewConverter;
import umc.UMC8th.domain.Member;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.CreateReviewRequest;
import umc.UMC8th.repository.MemberRepository;
import umc.UMC8th.repository.ReviewRepository;
import umc.UMC8th.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(CreateReviewRequest request) {
        Member member = memberRepository.findById(1L).orElseThrow(); // 하드코딩 부분
        Store store = storeRepository.findById(1L).orElseThrow();   // 하드코딩 부분

        Review review = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(review);
    }
}
