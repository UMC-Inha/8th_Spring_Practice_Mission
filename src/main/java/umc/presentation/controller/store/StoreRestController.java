package umc.presentation.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
            @RequestBody StoreRequestDTO.StoreLocationDTO storeLocationDTO){

        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(storeCommandService.modifyStoreLocation(storeLocationDTO)));
    }
}