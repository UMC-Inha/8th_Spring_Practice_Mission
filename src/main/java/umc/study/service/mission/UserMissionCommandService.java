package umc.study.service.mission;

import org.springframework.data.domain.Slice;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.request.UserMissionRequestDto;

public interface UserMissionCommandService {
    Slice<UserMission> findInProgressMissions(Long userId, Integer page, Integer size);
    UserMission challengeMission(UserMissionRequestDto.RegisterDto request);
    UserMission completeMission(UserMissionRequestDto.CompletedDto request);
}