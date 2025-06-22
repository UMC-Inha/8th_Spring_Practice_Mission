package umc.study.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.member.Member;
import umc.study.domain.review.Review;
import umc.study.repository.member.MemberJpaRepository;
import umc.study.repository.review.ReviewRepository;
import umc.study.web.controller.review.dto.ReviewResponseDTO;
import umc.study.web.converter.review.ReviewConverter;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final MemberJpaRepository memberJpaRepository;
    private final ReviewRepository reviewRepository;
    public Page<ReviewResponseDTO.getReviewListResultDto> getReviewListByMember(Long memberId, Pageable pageable) {
        Member member = memberJpaRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        return ReviewConverter.toGetReviewResultDTO(reviewRepository.findAllByMember(member, pageable));
    }
}
