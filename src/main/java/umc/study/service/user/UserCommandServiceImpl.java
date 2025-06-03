package umc.study.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.mapping.PreferFood;
import umc.study.domain.store.FoodCategory;
import umc.study.domain.user.User;
import umc.study.repository.foodcategory.FoodCategoryRepository;
import umc.study.repository.user.UserRepository;
import umc.study.web.dto.request.UserRequestDto;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser (UserRequestDto.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<PreferFood> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);
        userPreferList.forEach(userPrefer -> {userPrefer.setMember(newUser);});
        return userRepository.save(newUser);
    }
}


