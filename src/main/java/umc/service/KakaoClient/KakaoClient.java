package umc.service.KakaoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import umc.dto.KakaoDto;

@Component
public class KakaoClient {

	@Value("${spring.kakao.auth.client}")
	private String client;
	@Value("${spring.kakao.auth.redirect}")
	private String redirect;

	public KakaoDto.OAuthToken requestToken(String accessCode) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", client);
		params.add("redirect_url", redirect);
		params.add("code", accessCode);

		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		ResponseEntity<KakaoDto.OAuthToken> response = restTemplate.postForEntity(
			"https://kauth.kakao.com/oauth/token",
			kakaoTokenRequest,
			KakaoDto.OAuthToken.class);

		return response.getBody();
	}

	public KakaoDto.KakaoProfile requestProfile(KakaoDto.OAuthToken oAuthToken) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Authorization","Bearer "+ oAuthToken.getAccess_token());

		HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity<>(headers);

		ResponseEntity<KakaoDto.KakaoProfile> response = restTemplate.exchange(
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.GET,
			kakaoProfileRequest,
			KakaoDto.KakaoProfile.class
		);

		return response.getBody();
	}
}
