package umc.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.FoodCategoryHandler;
import umc.converter.UserConverter;
import umc.converter.UserPreferenceConverter;
import umc.domain.FoodCategory;
import umc.domain.User;

import umc.domain.mapping.UserPreference;
import umc.repository.foodCategory.FoodCategoryRepository;
import umc.repository.user.UserPreferenceRepository;
import umc.repository.user.UserRepository;
import umc.web.dto.user.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final UserPreferenceRepository userPreferenceRepository;
    private final FoodCategoryRepository foodCategoryRepository;


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
}