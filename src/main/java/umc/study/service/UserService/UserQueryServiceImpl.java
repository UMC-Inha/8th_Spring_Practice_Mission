package umc.study.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.User;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserResponseDto;
import umc.study.converter.UserConverter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto.UserInfoDTO getUserInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        return UserConverter.toUserInfoDTO(user);
    }

}
