package umc.study.web.controller.review;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.study.domain.member.Member;
import umc.study.service.review.ReviewQueryService;
import umc.study.validation.annotation.PageableParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewQueryController {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/members")
    public ResponseEntity<?> getReviewsByMember(HttpSession session, @ParameterObject @PageableParam Pageable pageable) {
        Long memberId = ((Member) session.getAttribute("loginMember")).getId();
        if (memberId == null) {
            return ResponseEntity.status(500).body("회원 조회 시 문제 발생");
        }
        return ResponseEntity.ok(reviewQueryService.getReviewListByMember(memberId, pageable));
    }
}
