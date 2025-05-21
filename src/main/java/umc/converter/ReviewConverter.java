package umc.converter;

import umc.domain.Location;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.domain.User;
import umc.web.dto.restaurant.RestaurantRequestDTO;
import umc.web.dto.review.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.createReviewDTO reviewDTO, Restaurant restaurant, User user) {

        return Review.builder()
                .content(reviewDTO.getContent())
                .stars(reviewDTO.getStars())
                .restaurant(restaurant)
                .user(user)
                .build();
    }

}
