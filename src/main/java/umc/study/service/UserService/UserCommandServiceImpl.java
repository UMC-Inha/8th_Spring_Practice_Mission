package umc.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.User;
import umc.study.domain.mapping.UserPrefer;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User joinUser(UserRequestDto.JoinDto request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserHandler(ErrorStatus.DUPLICATE_JOIN_REQUEST);
        }
        User newUser = UserConverter.toUser(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        newUser.encodePassword(encodedPassword);

        if (!request.getPreferCategory().isEmpty()) {
            List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                    .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    }).collect(Collectors.toList());

            List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

            userPreferList.forEach(userPrefer -> {
                userPrefer.setUser(newUser);
            });

        }
        return userRepository.save(newUser);
    }
    @Override
    @Transactional
    public UserResponseDto.LoginResultDTO loginUser(UserRequestDto.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }
}
