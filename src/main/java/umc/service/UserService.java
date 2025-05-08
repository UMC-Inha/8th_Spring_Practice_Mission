package umc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.domain.User;
import umc.dto.WithdrawUserDto;
import umc.repository.AlarmRepository;
import umc.repository.PreferredCategoryRepository;
import umc.repository.ReviewRepository.ReviewRepository;
import umc.repository.UserRepository.UserRepository;
import umc.repository.UserTermRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	private final AlarmRepository alarmRepository;
	private final PreferredCategoryRepository preferredCategoryRepository;
	private final UserTermRepository userTermRepository;

	@Transactional
	public WithdrawUserDto withdrawUser(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

		reviewRepository.deleteAllByUserId(userId);
		alarmRepository.deleteAllByUserId(userId);
		preferredCategoryRepository.deleteAllByUserId(userId);
		userTermRepository.deleteAllByUserId(userId);

		userRepository.delete(user);

		return new WithdrawUserDto(true, userId);
	}
}
