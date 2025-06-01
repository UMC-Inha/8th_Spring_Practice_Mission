package umc.converter;

import org.springframework.data.domain.Page;
import umc.domain.Location;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;
import umc.web.dto.restaurant.RestaurantRequestDTO;
import umc.web.dto.review.ReviewRequestDTO;
import umc.web.dto.review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.createReviewDTO reviewDTO, Restaurant restaurant, User user) {

        return Review.builder()
                .content(reviewDTO.getContent())
                .stars(reviewDTO.getStars())
                .restaurant(restaurant)
                .user(user)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){

        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getNickname())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}
