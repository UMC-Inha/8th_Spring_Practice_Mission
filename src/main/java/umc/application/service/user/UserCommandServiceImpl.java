package umc.application.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.application.converter.UserCategoryConverter;
import umc.application.converter.UserConverter;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.CategoryHandler;
import umc.infrastructure.persistence.entity.category.Category;
import umc.infrastructure.persistence.entity.category.UserCategory;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.category.CategoryRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;
import umc.presentation.dto.user.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request){
        User newUser = UserConverter.toUser(request);


        List<Category> categoryList = request.preferCategoryIdList().stream()
                .map(preferCategory -> categoryRepository.findById(preferCategory).orElseThrow(()
                                    -> new CategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).toList();
        List<UserCategory> UserCategoryList = UserCategoryConverter.toUserCategoryList(categoryList);
        UserCategoryList.forEach(userCategory -> userCategory.setUser(newUser));

        /*
        존재하는 Category Id만 들어온다고 가정했을 때, 굳이 에러체크를 할 필요가 없다면 다음과 같이 성능을 챙길 수 있다.

        List<Category> categoryList = categoryRepository.findAllCategoryByIds(request.preferCategoryIdList());
        List<UserCategory> UserCategoryList = UserCategoryConverter.toUserCategoryList(categoryList);
        UserCategoryList.forEach(userCategory -> userCategory.setUser(newUser));
        */
        return userRepository.save(newUser);
    }

}
