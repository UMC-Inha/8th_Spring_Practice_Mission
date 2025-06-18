package umc.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.domain.User;
import umc.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByEmail(username)
			.orElseThrow(() -> new GeneralException(ErrorStatus.EMAIL_NOT_FOUND));

		return org.springframework.security.core.userdetails.User
			.withUsername(user.getEmail())
			.password(user.getPassword())
			.roles(user.getRole().name())
			.build();
	}
}
