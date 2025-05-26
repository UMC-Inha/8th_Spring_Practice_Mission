package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.web.dto.Store.StoreRequestDto;
import umc.study.web.dto.Store.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.JoinResultDTO> join(@RequestBody @Valid StoreRequestDto.JoinDto request){
        Store store = storeQueryService.registerStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
