package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreCommandServiceImpl;
import umc.study.web.dto.StoreRequestDto;
import umc.study.web.dto.StoreResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreCommandServiceImpl storeCommandService;
    @PostMapping
    public ApiResponse<StoreResponseDto> addStore(@RequestBody @Valid StoreRequestDto request) {

            Store store = storeCommandService.addStore(request);
            return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }
}
