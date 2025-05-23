package umc.presentation.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.application.converter.UserConverter;
import umc.application.service.user.UserCommandService;
import umc.common.ApiPayload.ApiResponse;
import umc.presentation.dto.ResponseEntityUtil;
import umc.presentation.dto.user.UserRequestDTO;
import umc.presentation.dto.user.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
        return ResponseEntityUtil.buildResponseEntityWithStatus(
                ApiResponse.onSuccess(UserConverter.toJoinResultDto(userCommandService.joinUser(request))), HttpStatus.CREATED);
    }
}
