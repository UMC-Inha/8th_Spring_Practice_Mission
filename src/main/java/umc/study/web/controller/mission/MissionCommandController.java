package umc.study.web.controller.mission;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.service.mission.MissionCommandService;
import umc.study.web.controller.mission.dto.MissionRequestDTO;
import umc.study.web.controller.mission.dto.MissionRequestDTO.AddMemberMission;
import umc.study.web.converter.mission.MissionConverter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionCommandController {
    private final MissionCommandService missionCommandService;

    //가게에 미션 추가
    @PostMapping("/")
    public ResponseEntity<?> join(@RequestBody @Valid MissionRequestDTO.AddMission request) {
        return ResponseEntity.ok(MissionConverter.toAddResultDTO(missionCommandService.addMissionToStore(request)));
    }

    // 가게의 미션을 회원의 도전 중인 미션에 추가 (하나만)
    @PostMapping("/members")
    public ResponseEntity<?> addMemberMission(@RequestBody @Valid AddMemberMission request) {
        return ResponseEntity.ok(MissionConverter.toAddResultDTO(missionCommandService.addMemberMission(request)));
    }
}
