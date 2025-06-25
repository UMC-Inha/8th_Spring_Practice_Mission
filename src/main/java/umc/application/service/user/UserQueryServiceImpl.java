package umc.application.service.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.UserConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.jwt.JwtTokenProvider;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.user.UserRepository;
import umc.presentation.dto.user.UserResponseDTO;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDto getUserInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        return UserConverter.toUserInfoDto(user);
    }
}
