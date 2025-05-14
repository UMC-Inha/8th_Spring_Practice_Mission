package umc.UMC8th.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.TempConverter;
import umc.UMC8th.dto.TempResponse;
import umc.UMC8th.service.TempService.TempQueryService;



@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        // return ApiResponse.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO()); // Code 클래스가 없기때문에 일단 코드 생략
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
