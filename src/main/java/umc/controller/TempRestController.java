package umc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.ApiResponse;
import umc.converter.TempConverter;
import umc.dto.TempResponse;
import umc.service.TempService.TempQueryService;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

	private final TempQueryService tempQueryService;

	@GetMapping("/test")
	public ApiResponse<TempResponse.TempTestDTO> testAPI(){
		return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
	}

	@GetMapping("/exception")
	public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
		tempQueryService.CheckFlag(flag);
		return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
	}

	@GetMapping("/discordError")
	public ApiResponse<Void> discordTestAPI() {
		throw new RuntimeException("500 에러 발생");
	}
}
