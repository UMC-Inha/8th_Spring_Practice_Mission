package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.storeService.StoreService;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDto> create(@RequestBody @Valid StoreRequestDTO.CreateStoreDto request) {
        Store newStore = storeService.create(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDto(newStore));
    }
}