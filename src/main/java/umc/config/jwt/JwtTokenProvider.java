package umc.config.jwt;

import static java.time.LocalTime.*;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.config.properties.Constants;
import umc.config.properties.JwtProperties;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

	private final JwtProperties jwtProperties;

	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
	}

	// 토큰 생성
	public String generateToken(Authentication authentication) {
		String email = authentication.getName();

		return Jwts.builder()
			.setSubject(email) // 식별값
			.claim("role", authentication.getAuthorities().iterator().next().getAuthority()) // 권한 등 추가 정보
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration().getAccess()))
			.signWith(getSigningKey(), SignatureAlgorithm.HS256)
			.compact();
	}

	// 리프레시 토큰 생성
	public String generateRefreshToken() {
		return Jwts.builder()
			.setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration().getRefresh()))
			.signWith(getSigningKey(), SignatureAlgorithm.HS256)
			.compact();
	}

	// Token 유효성 판단
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	// HTTP Request로부터 Token 추출 및 Authentication 반환
	public Authentication extractAuthentication(HttpServletRequest request){
		String accessToken = resolveToken(request);
		if(accessToken == null || !validateToken(accessToken)) {
			throw new GeneralException(ErrorStatus.INVALID_TOKEN);
		}
		return getAuthentication(accessToken);
	}

	// Request 로부터 토큰 추출
	public static String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(Constants.AUTH_HEADER);
		System.out.println(bearerToken);
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(Constants.TOKEN_PREFIX)) {
			return bearerToken.substring(Constants.TOKEN_PREFIX.length());
		}
		return null;
	}

	// 토큰으로 부터 Authentication 추출
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder()
			.setSigningKey(getSigningKey())
			.build()
			.parseClaimsJws(token)
			.getBody();

		String email = claims.getSubject();
		String role = claims.get("role", String.class);

		// org.springframework.security.core.userdetails.User
		User principal = new User(email, "", Collections.singleton(() -> role));
		return new UsernamePasswordAuthenticationToken(principal, token, principal.getAuthorities());
	}
}
