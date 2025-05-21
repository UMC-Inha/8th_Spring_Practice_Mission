package umc.service.restaurant;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.LocationHandler;
import umc.converter.RestaurantConverter;
import umc.domain.Location;
import umc.domain.Restaurant;
import umc.domain.RestaurantFood;
import umc.domain.RestaurantImage;
import umc.repository.location.LocationRepository;
import umc.repository.restaurant.RestaurantFoodRepository;
import umc.repository.restaurant.RestaurantImageRepository;
import umc.repository.restaurant.RestaurantRepository;
import umc.web.dto.restaurant.RestaurantRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;

    private final RestaurantFoodRepository restaurantFoodRepository;
    private final RestaurantImageRepository restaurantImageRepository;

    @Override
    @Transactional
    public void createRestaurant(RestaurantRequestDTO.createRestaurantDto request, Long locationId) {

        Location location = locationRepository.findById(locationId).orElseThrow(
                () -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND)
        );

        Restaurant restaurant = RestaurantConverter.toRestaurant(request, location);
        restaurantRepository.save(restaurant);

        // foodList → RestaurantFood 리스트 변환
        List<RestaurantFood> foods = request.getFoodList().stream()
                .map(foodName -> RestaurantFood.builder()
                        .restaurant(restaurant)
                        .foodName(foodName)
                        .build()
                )
                .collect(Collectors.toList());

        // 한 번에 저장
        restaurantFoodRepository.saveAll(foods);

        // imageList -> RestaurantImage 리스트 변환
        List<RestaurantImage> images = request.getImageList().stream()
                .map(image -> RestaurantImage.builder()
                        .restaurant(restaurant)
                        .image(image)
                        .build()
                )
                .collect(Collectors.toList());

        // 한 번에 저장
        restaurantImageRepository.saveAll(images);






    }
}
