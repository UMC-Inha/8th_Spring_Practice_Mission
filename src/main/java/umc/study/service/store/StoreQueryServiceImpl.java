package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.member.Member;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;
import umc.study.repository.review.ReviewRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.repository.store.StoreRepositoryImpl;
import umc.study.web.controller.review.dto.ReviewResponseDTO;
import umc.study.web.controller.store.dto.StoreReponseDTO;
import umc.study.web.converter.store.StoreConverter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //수정이 일어나지 않는 QueryService 경우 readOnly = true 설정하는 게 안전함
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final StoreRepositoryImpl storeRepositoryImpl;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, BigDecimal score) {
        List<Store> filteredStores = storeRepositoryImpl.dynamicQueryWithBooleanBuilder(name, score);
        //for-each루프를 함수형 스타일로 표현한 것
        filteredStores.forEach(store -> System.out.println("Store: " + store));
        //for (Store store : filteredStores) {
        //  System.out.println("Store: " + store);
        //}
        return filteredStores;
    }

    @Override
    public Page<StoreReponseDTO.ReviewPreViewDTO> getReviewList(Long storeId, Pageable pageable, Member member) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        return StoreConverter.toReviewPreviewList(reviewRepository.findAllByStore(store, pageable), member);
    }

}
