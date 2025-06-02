package umc.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.MemberHandler;
import umc.apiPayload.exception.handler.RestaurantHandler;
import umc.converter.review.ReviewConverter;
import umc.domain.Member;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.dto.review.ReviewRequestDTO;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.ReviewImgRepository;
import umc.repository.member.MemberRepository;
import umc.repository.review.ReviewRepository;
import umc.service.AnswerService;
import umc.service.restaurant.RestaurantService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewImgRepository reviewImgRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    private final RestaurantService restaurantService;
    private final AnswerService answerService;

    @Transactional
    public void deleteReviewByMember(Long memberId) {

        List<Long> reviewIdList = reviewRepository.findAllReviewIdsByMemberId(memberId);

        answerService.deleteAnswerByReview(reviewIdList);
        reviewImgRepository.deleteAllByReviewIds(reviewIdList);
        reviewRepository.deleteAllByReviewIds(reviewIdList);
    }

    @Transactional
    public Review writeReview(ReviewRequestDTO.WriteReviewDto request, Long restaurantId) {

        Restaurant findRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Member findMember = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, findRestaurant, findMember);

        reviewRepository.save(newReview);

        restaurantService.updateScoreAvg(findRestaurant);

        return newReview;
    }

    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return reviewPage;
    }

    public Page<Review> getReviewListByMember(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return reviewPage;
    }
}
