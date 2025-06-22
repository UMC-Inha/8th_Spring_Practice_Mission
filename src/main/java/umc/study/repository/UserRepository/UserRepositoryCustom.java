package umc.study.repository.UserRepository;

import umc.study.web.dto.UserResponseDto;

import java.util.Optional;

public interface UserRepositoryCustom {
    UserResponseDto findUserInfoById(Long userId);
}
