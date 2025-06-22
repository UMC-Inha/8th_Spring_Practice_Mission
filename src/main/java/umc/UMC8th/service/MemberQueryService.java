package umc.UMC8th.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.mapping.MemberMission;
import umc.UMC8th.dto.MemberResponseDTO;

public interface MemberQueryService {
    Page<Review> getMyReviews(Long memberId, int page);
    Page<MemberMission> getOngoingMissions(Long memberId, int page);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}