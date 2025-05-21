package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.apiPayload.ApiResponse;
import umc.converter.user.UserConverter;
import umc.domain.User;
import umc.service.user.UserCommandService;
import umc.validation.annotation.ExistMission;
import umc.validation.annotation.ExistUser;
import umc.web.dto.user.UserRequestDTO;
import umc.web.dto.user.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){

        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));

    }

    // TODO 하드코딩 한 User 값을 받도록 바꿔주기
    @PostMapping("/missions/{missionId}")
    public ApiResponse<String> challengeMission( @ExistMission @PathVariable Long missionId){

        userCommandService.challengeMission(missionId);
        return ApiResponse.onSuccess("해당 미션의 도전을 시작하셨습니다");
    }
}
