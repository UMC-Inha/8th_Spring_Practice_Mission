package umc.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.ApiPayload.ApiResponse;
import umc.mapper.TempDTOMapper;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.temp.TempResponse;
import umc.service.temp.TempQueryService;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<TempResponse.TempTestDTO>> testAPI(){
        return ResponseEntityUtil.buildResponseEntityWithStatus(ApiResponse.onSuccess(TempDTOMapper.toTempTestDTO()), HttpStatus.CREATED);
    }

    @GetMapping("/exception")
    public ResponseEntity<ApiResponse<TempResponse.TempExceptionDTO>> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseEntityUtil.buildDefaultResponseEntity(ApiResponse.onSuccess(TempDTOMapper.toTempExceptionDTO(flag)));
    }
}