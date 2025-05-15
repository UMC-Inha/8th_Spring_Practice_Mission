package umc.repository.UserRepository;

import umc.dto.MyPageDto;

public interface UserRepositoryCustom {

	MyPageDto findMyPageByUserId(Long userId);
}
