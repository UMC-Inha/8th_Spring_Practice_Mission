package umc.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.apiPayload.exception.handler.FoodCategoryHandler;
import umc.apiPayload.exception.handler.UserHandler;
import umc.config.security.jwt.JwtTokenProvider;
import umc.converter.user.UserConverter;
import umc.converter.user.UserPreferenceConverter;
import umc.domain.FoodCategory;
import umc.domain.Mission;
import umc.domain.User;

import umc.domain.mapping.UserMission;
import umc.domain.mapping.UserPreference;
import umc.repository.foodCategory.FoodCategoryRepository;
import umc.repository.mission.MissionRepository;
import umc.repository.user.UserMissionRepository;
import umc.repository.user.UserPreferenceRepository;
import umc.repository.user.UserRepository;
import umc.web.dto.user.UserRequestDTO;
import umc.web.dto.user.UserResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final UserPreferenceRepository userPreferenceRepository;
    private final UserMissionRepository userMissionRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final MissionRepository missionRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPreference> userPreferenceList = UserPreferenceConverter.toUserPreferenceList(foodCategoryList);

        userPreferenceList.forEach(userPreference -> {userPreference.setUser(newUser);});

        return userRepository.save(newUser);
    }

    // TODO 하드 코딩한 user 값 변경해주기
    @Override
    public void challengeMission(Long missionId) {

        User user = userRepository.findById(1L).orElseThrow(
                () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Mission mission = missionRepository.findById(missionId).orElseThrow(
                () -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND)
        );

        UserMission userMission = UserMission.builder()
                .isCompleted(Boolean.FALSE)
                .user(user)
                .mission(mission)
                .build();

        userMissionRepository.save(userMission);

    }

    @Override
    public UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserHandler(ErrorStatus.USER_NOT_FOUND));


        if(!request.getPassword().equals(user.getPassword())) {
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