package umc.study.service.UserMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.MissionRequestDto;
import umc.study.web.dto.ReviewRequestDto;
import umc.study.web.dto.UserResponseDto;

public interface UserMissionCommandService {
    UserMission createUserMission(MissionRequestDto requestDto);
    Page<UserMission> getOngoingMissions(Long StoreId, Integer page);
}
