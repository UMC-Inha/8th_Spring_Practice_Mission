package umc.study.service.mission;

import umc.study.domain.mission.Mission;
import umc.study.web.controller.mission.dto.MissionRequestDTO;

public interface MissionCommandService{
    Mission addMissionToStore(MissionRequestDTO.AddMission request);
    Mission addMemberMission(MissionRequestDTO.AddMemberMission request);
}
