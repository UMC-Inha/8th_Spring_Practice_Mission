package umc.study.repository.UserRepository;

import umc.study.web.dto.UserRequestDto;

public interface UserRepositoryCustom {
    //List<User> dynamicQueryWithBooleanBuilder(String name, Float score);
    UserRequestDto findUserInfoById(Long userId);
}
