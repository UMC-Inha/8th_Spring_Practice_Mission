package umc.UMC8th.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.StoreConverter;
import umc.UMC8th.dto.StoreResponseDTO;
import umc.UMC8th.service.StoreQueryService;
import umc.UMC8th.validation.annotation.ExistStore;
import umc.UMC8th.validation.annotation.PositivePage;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class StoreMissionController {

    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 조회하는 API (페이징 포함)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE404", description = "해당 가게가 존재하지 않습니다.")
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 ID"),
            @Parameter(name = "page", description = "1 이상의 페이지 번호")
    })
    public ApiResponse<StoreResponseDTO.MissionPreviewListDTO> getStoreMissions(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @PositivePage @RequestParam(name = "page") int page
    ) {
        var missionPage = storeQueryService.getMissionList(storeId, page - 1);
        var dto = StoreConverter.toMissionPreviewListDTO(missionPage);
        return ApiResponse.onSuccess(dto);
    }
}