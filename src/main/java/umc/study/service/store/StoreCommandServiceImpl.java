package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.store.FoodCategory;
import umc.study.domain.store.Region;
import umc.study.domain.store.Store;
import umc.study.repository.foodcategory.FoodCategoryRepository;
import umc.study.repository.region.RegionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.dto.request.StoreRequestDto;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Store registerStore(StoreRequestDto.RegisterDto request) {
        Region region =  regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        FoodCategory category = foodCategoryRepository.findById(request.getFoodCategoryId())
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request, region, category);
        return storeRepository.save(newStore);
    }
}
