package umc.service.RestaurantService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.GeneralException;
import umc.converter.RestaurantConverter;
import umc.domain.Category;
import umc.domain.Region;
import umc.domain.Restaurant;
import umc.dto.RestaurantRequestDto;
import umc.repository.CategoryRepository.CategoryRepository;
import umc.repository.RegionRepository.RegionRepository;
import umc.repository.RestaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	private final RegionRepository regionRepository;

	@Override
	@Transactional
	public Restaurant joinRestaurant(RestaurantRequestDto.JoinDto request) {

		Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);
		Region region = regionRepository.findByName(request.getRegionName()).orElseThrow(() -> new GeneralException(
			ErrorStatus.REGION_NOT_FOUND));
		Category category = categoryRepository.findById(request.getFoodCategory()).orElseThrow(() -> new GeneralException(
			ErrorStatus.FOOD_CATEGORY_NOT_FOUND
		));

		// 연관 관계 설정
		newRestaurant.setRegion(region);
		newRestaurant.setCategory(category);

		return restaurantRepository.save(newRestaurant);
	}
}
