package umc.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.MemberDTO.MemberResponseDTO;

public interface MemberQueryService {
    Page<Review> getMemberReviewList(Long memberId, Integer page);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
