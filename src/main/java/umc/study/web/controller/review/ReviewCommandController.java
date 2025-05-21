package umc.study.web.controller.review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.study.domain.review.Review;
import umc.study.service.review.ReviewCommandsServiceImpl;
import umc.study.web.controller.review.dto.ReviewRequestDTO.AddDto;
import umc.study.web.converter.review.ReviewConverter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewCommandController {
    private final ReviewCommandsServiceImpl reviewCommandsService;

    // 가게에 리뷰 추가
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody @Valid AddDto request) {
        Review review = reviewCommandsService.addReview(request);
        return ResponseEntity.ok(ReviewConverter.toAddResultDTO(review));
    }
}
