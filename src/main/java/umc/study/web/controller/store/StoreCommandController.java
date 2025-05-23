package umc.study.web.controller.store;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.study.domain.store.Store;
import umc.study.service.store.StoreCommandServiceImpl;
import umc.study.web.controller.store.dto.StoreRequestDTO;
import umc.study.web.converter.store.StoreConverter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreCommandController {
    private final StoreCommandServiceImpl storeCommandService;

    // 특정 지역에 가게 추가
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody @Valid StoreRequestDTO.AddDto request) {
        Store store = storeCommandService.addStore(request);
        return ResponseEntity.ok(StoreConverter.toAddResultDTO(store));
    }
}
