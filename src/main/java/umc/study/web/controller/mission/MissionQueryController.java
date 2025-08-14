package umc.study.web.controller.mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.member.Member;
import umc.study.service.member.MemberMissionQueryService;
import umc.study.validation.annotation.PageableParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionQueryController {
    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/in-progress")
    @Operation(summary = "현재 진행 중인 미션 목록 조회 API", description = "현재 로그인한 회원이 진행 중인 미션 목록을 조회하는 API, 페이징을 포함합니다.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 (0부터 시작)", in = ParameterIn.QUERY)
    })
    public ResponseEntity<?> getInProgressMissions(HttpSession session, @ParameterObject @PageableParam Pageable pageable) {

        Long memberId = ((Member) session.getAttribute("loginMember")).getId();
        if (memberId == null) {
            return ResponseEntity.status(500).body("회원 조회 시 문제 발생");
        }

        return ResponseEntity.ok(memberMissionQueryService.getCompletedAndInProgressMission(
                        memberId,
                        MissionStatus.IN_PROGRESS,
                        pageable
                )
        );
    }
}
