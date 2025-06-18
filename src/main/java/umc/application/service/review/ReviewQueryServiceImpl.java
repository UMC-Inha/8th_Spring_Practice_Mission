package umc.application.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.common.ApiPayload.code.status.ErrorStatus;
import umc.common.ApiPayload.exception.handler.UserHandler;
import umc.infrastructure.persistence.entity.review.Review;
import umc.infrastructure.persistence.entity.store.Store;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.repository.review.ReviewRepository;
import umc.infrastructure.persistence.repository.store.StoreRepository;
import umc.infrastructure.persistence.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page){
        Store store = storeRepository.findById(StoreId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Review> getReviewListByUserId(Long userId, Integer page) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        return reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
    }


}
