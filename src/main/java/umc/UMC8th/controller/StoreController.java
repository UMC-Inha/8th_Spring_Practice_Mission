package umc.UMC8th.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.StoreConverter;
import umc.UMC8th.domain.Store;
import umc.UMC8th.dto.CreateStoreRequest;
import umc.UMC8th.dto.StoreResponse;
import umc.UMC8th.service.StoreCommandService;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponse> createStore(@RequestBody @Valid CreateStoreRequest request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponse(store));
    }
}
