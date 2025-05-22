package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exceptition.GeneralException;
import umc.study.converter.StoreConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public Store addStore(StoreRequestDto request) {
        Store newStore = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
        region.setStore(newStore);
        newStore.setRegion(region);
        List<FoodCategory> foodCategoryList = request.getFoodCategoryId().stream()
                .map(id -> foodCategoryRepository.findById(id)
                        .orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());
        foodCategoryList.forEach(newFoodCategory -> newFoodCategory.setStore(newStore));
        return storeRepository.save(newStore);
    }
}
