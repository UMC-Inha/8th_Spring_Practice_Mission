package umc.service.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.FoodCategoryHandler;
import umc.apiPayload.exception.handler.LocationHandler;
import umc.converter.restaurant.RestaurantConverter;
import umc.domain.FoodCategory;
import umc.domain.Location;
import umc.domain.Restaurant;
import umc.domain.Review;
import umc.dto.restaurant.RestaurantRequestDTO;
import umc.repository.RestaurantRepository.RestaurantRepository;
import umc.repository.foodCategory.FoodCategoryRepository;
import umc.repository.location.LocationRepository;
import umc.repository.review.ReviewRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final LocationRepository locationRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Restaurant create(RestaurantRequestDTO.CreateRestaurantDto request) {

        Location findLocation = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        FoodCategory findFoodCategory = foodCategoryRepository.findById(request.getFoodCategory())
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request, findLocation, findFoodCategory);

        restaurantRepository.save(newRestaurant);

        return newRestaurant;
    }

    @Transactional
    public Double updateScoreAvg(Restaurant restaurant) {
        Double resultScoreAvg = 0.0;

        List<Review> reviewList = reviewRepository.findAllByRestaurantId(restaurant.getId())
                .orElse(new ArrayList<>());

        if (!reviewList.isEmpty()) {
            for (Review review : reviewList) {
                resultScoreAvg += review.getScore();
            }
            resultScoreAvg = resultScoreAvg / reviewList.size();
            BigDecimal truncateResultScoreAvg = BigDecimal
                    .valueOf(resultScoreAvg)
                    .setScale(1, RoundingMode.DOWN);

            resultScoreAvg = truncateResultScoreAvg.doubleValue();
        }

        restaurant.updateScoreAvg(resultScoreAvg);
        return resultScoreAvg;
    }
}
