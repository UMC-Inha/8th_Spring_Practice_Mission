package umc.UMC8th.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.MemberConverter;
import umc.UMC8th.domain.Member;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;
import umc.UMC8th.service.MemberCommandService;
import umc.UMC8th.service.MemberQueryService;
import umc.UMC8th.validation.annotation.ExistMember;
import umc.UMC8th.validation.annotation.PositivePage;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDto> join(
            @RequestBody @Valid MemberRequestDTO.JoinDto request) {

        Member savedMember = memberCommandService.joinMember(request);


        return ApiResponse.onSuccess(
                MemberConverter.toJoinResultDto(
                        savedMember,
                        request.getPreferCategory().toString() // List<Long> → String으로 변환
                )
        );
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "회원이 작성한 리뷰 목록을 조회하며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER404", description = "해당 유저가 존재하지 않습니다.")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID"),
            @Parameter(name = "page", description = "1 이상의 페이지 번호")
    })
    public ApiResponse<MemberResponseDTO.MyReviewListDTO> getMyReviews(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PositivePage @RequestParam(name = "page") int page
    ) {
        var reviewPage = memberQueryService.getMyReviews(memberId, page - 1);
        var dto = MemberConverter.toMyReviewListDTO(reviewPage);
        return ApiResponse.onSuccess(dto);
    }

    @GetMapping("/{memberId}/missions/ongoing")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "진행중인 미션 목록을 조회합니다. page 번호를 query string으로 주세요.(1부터 시작)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER404", description = "해당 유저가 존재하지 않습니다.")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID"),
            @Parameter(name = "page", description = "1 이상의 페이지 번호")
    })
    public ApiResponse<MemberResponseDTO.MissionPreviewListDTO> getOngoingMissions(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PositivePage @RequestParam(name = "page") int page
    ) {
        var missionPage = memberQueryService.getOngoingMissions(memberId, page - 1);
        var dto = MemberConverter.toMissionPreviewListDTO(missionPage);
        return ApiResponse.onSuccess(dto);
    }
}