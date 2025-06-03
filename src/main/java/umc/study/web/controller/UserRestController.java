package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.user.User;
import umc.study.service.user.UserCommandService;
import umc.study.web.dto.request.UserRequestDto;
import umc.study.web.dto.response.UserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    @Operation(summary = "회원가입 API", description = "서비스 회원가입을 위한 API 입니다.")
    public ApiResponse<UserResponseDto.JoinResultDTO> join(@RequestBody @Valid UserRequestDto.JoinDto request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDto(user));
    }
}
