package umc.domain.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

	@Id
	private String email;

	private String value;

	public RefreshToken updateValue(String token) {
		this.value = token;
		return this;
	}
}
