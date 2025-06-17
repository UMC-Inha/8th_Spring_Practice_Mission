package umc.repository.RefreshTokenRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.domain.security.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	Optional<RefreshToken> findByEmail(String email);
}
