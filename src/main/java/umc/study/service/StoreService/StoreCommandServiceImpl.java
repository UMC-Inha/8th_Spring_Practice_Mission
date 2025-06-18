package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exceptition.GeneralException;
import umc.study.converter.StoreConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
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
    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Store addStore(StoreRequestDto request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        List<FoodCategory> foodCategoryList = request.getFoodCategoryId().stream()
                .map(id -> foodCategoryRepository.findById(id)
                        .orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .map(category -> FoodCategory.builder()
                        .id(category.getId()) // 실제 값 복사
                        .name(category.getName())
                        .build())
                .collect(Collectors.toList());

        Store newStore = Store.builder()
                .name(request.getName())
                .region(region)
                .foodCategories(foodCategoryList)
                .build();

        region.getStoreList().add(newStore);
        foodCategoryList.forEach(cat -> newStore.getFoodCategories().add(cat));

        return storeRepository.save(newStore);
    }
    // dto로 던지는게 좋음 (명확성)

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
