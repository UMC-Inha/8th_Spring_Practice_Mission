package umc.UMC8th.repository.MyPageRepository;

import umc.UMC8th.dto.InquiryResponse;
import umc.UMC8th.dto.MyPageUserInfoResponse;
import umc.UMC8th.dto.NotificationResponse;

import java.util.List;

public interface MyPageRepositoryCustom {
    MyPageUserInfoResponse getUserInfo(Long memberId);
    List<InquiryResponse> getUserInquiries(Long memberId);
    List<NotificationResponse> getUserNotifications(Long memberId);
}
