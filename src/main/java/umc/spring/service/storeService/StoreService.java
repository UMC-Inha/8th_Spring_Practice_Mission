package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.Exception.handler.LocationHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Location;
import umc.spring.domain.Store;
import umc.spring.repository.foodCategory.FoodCategoryRepository;
import umc.spring.repository.location.LocationRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public Store create(StoreRequestDTO.CreateStoreDto request){

        Location findLocation = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));
        FoodCategory findFoodCategory = foodCategoryRepository.findById(request.getFoodCategory())
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, findLocation, findFoodCategory);
        storeRepository.save(newStore);

        return newStore;
    }
}
