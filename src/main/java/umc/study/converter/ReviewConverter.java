package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.ReviewImage;
import umc.study.web.dto.Review.ReviewRequestDto;
import umc.study.web.dto.Review.ReviewResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ReviewConverter {

    public static ReviewResponseDto.JoinResultDTO toJoinResultDTO(Review review){

        List<String> imageUrlList = review.getReviewImageList().stream().map(
                ReviewImage::getImageUrl
        ).toList();

        return ReviewResponseDto.JoinResultDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .imageUrlList(imageUrlList)
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDto.JoinDto request){
        request.getImgaeUrlList().forEach(imageUrl -> {
            toReviewImage(imageUrl);
        });

         return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .reviewImageList(new ArrayList<>())
                .build();
    }

    public static ReviewImage toReviewImage(String imageUrl){
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .build();
    }
}
