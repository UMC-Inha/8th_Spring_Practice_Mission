package umc.UMC8th.service;

import org.springframework.data.domain.Page;
import umc.UMC8th.domain.Review;
import umc.UMC8th.domain.mapping.MemberMission;

public interface MemberQueryService {
    Page<Review> getMyReviews(Long memberId, int page);
    Page<MemberMission> getOngoingMissions(Long memberId, int page);
}