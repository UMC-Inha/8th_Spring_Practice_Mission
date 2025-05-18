package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;

import java.math.BigDecimal;

public class ReviewConverter {
    public static Review toEntity(String content, BigDecimal rating, Store store, User user) {
        return Review.builder()
                .content(content)
                .rating(rating)
                .store(store)
                .user(user)
                .build();
    }
}