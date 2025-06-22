package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.User;
import umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.study.service.UserService.UserCommandService;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final MissionCommandServiceImpl missionCommandServiceImpl;

    @PostMapping("/")
    public ApiResponse<UserResponseDto.JoinResultDTO> join(@RequestBody @Valid UserRequestDto.JoinDto request){
        log.info(">>> 회원가입 요청 도착: {}", request);
        log.info(">>> Gender 값: {}", request.getGender());
        log.info(">>> Gender 타입: {}", request.getGender() != null ? request.getGender().getClass().getName() : "null");
        log.info(">>> Role 값: {}", request.getRole());
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}
