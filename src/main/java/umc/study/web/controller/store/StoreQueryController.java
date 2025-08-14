package umc.study.web.controller.store;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.study.domain.member.Member;
import umc.study.service.mission.MissionQueryService;
import umc.study.service.store.StoreQueryServiceImpl;
import umc.study.validation.annotation.PageableParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreQueryController {
    private final StoreQueryServiceImpl storeQueryService;
    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API, 페이징을 포함합니다. query String으로 Page 번호 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호 (0부터 시작)", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "페이지 크기", in = ParameterIn.QUERY),
            @Parameter(name = "sort", description = "정렬 기준, 예: sort=createdDate,desc", in = ParameterIn.QUERY)
    })
    public ResponseEntity<?> getReviewList(@PathVariable Long storeId, @ParameterObject @PageableParam Pageable pageable, HttpSession session) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        return ResponseEntity.ok(storeQueryService.getReviewList(storeId, pageable, loginMember));
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API, 페이징을 포함합니다. query String으로 Page 번호 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호 (0부터 시작)", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "페이지 크기", in = ParameterIn.QUERY),
            @Parameter(name = "sort", description = "정렬 기준, 예: sort=createdDate,desc", in = ParameterIn.QUERY)
    })
    public ResponseEntity<?> getMissionList(@PathVariable Long storeId, @ParameterObject @PageableParam Pageable pageable, HttpSession session) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        return ResponseEntity.ok(missionQueryService.getMissionListByStore(storeId, pageable));
    }
}
//@ParameterObject로 자동 문서화

//내가 작성한 리뷰 목록
//특정 가게의 미션 목록
// 내가 진행 중인 미션 목록
