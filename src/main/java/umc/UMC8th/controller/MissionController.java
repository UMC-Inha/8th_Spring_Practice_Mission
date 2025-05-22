package umc.UMC8th.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.domain.Mission;
import umc.UMC8th.dto.CreateMissionRequest;
import umc.UMC8th.service.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<String> createMission(@RequestBody @Valid CreateMissionRequest request) {
        Mission mission = missionService.createMission(request);
        return ResponseEntity.ok("미션이 추가되었습니다. ID: " + mission.getId());
    }
}
