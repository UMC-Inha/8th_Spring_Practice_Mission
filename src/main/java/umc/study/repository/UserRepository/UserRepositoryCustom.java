package umc.study.repository.UserRepository;

import umc.study.domain.User;
import umc.study.web.dto.UserInfoDto;

import java.util.List;

public interface UserRepositoryCustom {
    //List<User> dynamicQueryWithBooleanBuilder(String name, Float score);
    UserInfoDto findUserInfoById(Long userId);
}
