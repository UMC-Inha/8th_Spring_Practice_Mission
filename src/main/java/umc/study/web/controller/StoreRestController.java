package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.store.Store;
import umc.study.service.store.StoreCommandService;
import umc.study.web.dto.request.StoreRequestDto;
import umc.study.web.dto.response.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.RegisterResultDto> registerStore(
            @RequestBody @Valid StoreRequestDto.RegisterDto request) {
        Store store = storeCommandService.registerStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDto(store));
    }
}
