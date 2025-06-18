package umc.application.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.UserCategoryConverter;
import umc.application.converter.UserConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.CategoryHandler;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.jwt.JwtTokenProvider;
import umc.infrastructure.persistence.entity.category.Category;
import umc.infrastructure.persistence.entity.category.UserCategory;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.category.CategoryRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;
import umc.presentation.dto.user.UserRequestDTO;
import umc.presentation.dto.user.UserResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public UserResponseDTO.JoinResultDto joinUser(UserRequestDTO.JoinDto request){
        User newUser = UserConverter.toUser(request);
        newUser.encodePassword(passwordEncoder.encode(request.password()));

        //존재하는 Category Id만 들어온다고 가정했을 때, 굳이 에러체크를 할 필요가 없다면 다음과 같이 성능을 챙길 수 있다.
        List<Category> categoryList = categoryRepository.findAllCategoryByIds(request.preferCategoryIdList());
        List<UserCategory> UserCategoryList = UserCategoryConverter.toUserCategoryList(categoryList);
        UserCategoryList.forEach(userCategory -> userCategory.setUser(newUser));

        return UserConverter.toJoinResultDto(userRepository.save(newUser));
    }

    @Override
    public UserResponseDTO.LoginResultDto loginUser(UserRequestDTO.LoginRequestDto request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new CategoryHandler(ErrorStatus.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new UserHandler(ErrorStatus.INVALID_PW);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null, Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDto(user, accessToken);
    }
}


