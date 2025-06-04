package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.validation.annotation.ValidPageableIndex;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.web.dto.Mission.MissionResponseDto;
import umc.study.web.dto.Store.StoreRequestDto;
import umc.study.web.dto.Store.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/missions")
    public ApiResponse<Page<MissionResponseDto.JoinResultDTO>> getStoreMissions(
            @ValidPageableIndex
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable,
            @PathVariable("storeId") Long storeId
    ) {
        return ApiResponse.onSuccess(storeQueryService.findStoreMissions(storeId, pageable));
    }

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.JoinResultDTO> join(@RequestBody @Valid StoreRequestDto.JoinDto request){
        Store store = storeQueryService.registerStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
