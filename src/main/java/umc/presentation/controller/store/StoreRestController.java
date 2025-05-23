package umc.presentation.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.application.service.store.StoreCommandService;
import umc.common.ApiPayload.ApiResponse;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.store.StoreRequestDTO;
import umc.presentation.dto.store.StoreResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PatchMapping("/location")
    public ResponseEntity<ApiResponse<StoreResponseDTO.StoreLocationResultDto>> modifyStoreLocation(
            @RequestBody StoreRequestDTO.StoreLocationDTO storeLocationDTO) {

        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(storeCommandService.modifyStoreLocation(storeLocationDTO)));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> createStore(@RequestBody StoreRequestDTO.StoreCreateDto request) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(storeCommandService.createStore(request)), HttpStatus.CREATED);
    }


}