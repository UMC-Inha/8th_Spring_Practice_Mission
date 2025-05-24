package umc.study.service.mission;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.request.UserMissionRequestDto;
import umc.study.web.dto.response.UserMissionResponseDto;

public interface UserMissionCommandService {
    UserMission challengeMission(UserMissionRequestDto.RegisterDto request);
}