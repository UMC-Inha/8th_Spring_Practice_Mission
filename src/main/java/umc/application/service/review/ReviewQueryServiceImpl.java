package umc.application.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.repository.review.ReviewRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page){
        Store store = storeRepository.findById(StoreId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

}
