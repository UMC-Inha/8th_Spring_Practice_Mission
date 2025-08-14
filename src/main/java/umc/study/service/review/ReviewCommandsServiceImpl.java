package umc.study.service.review;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Image;
import umc.study.domain.review.Review;
import umc.study.domain.store.Store;
import umc.study.repository.image.ImageRepository;
import umc.study.repository.review.ReviewRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.controller.review.dto.ReviewRequestDTO.AddDto;
import umc.study.web.converter.review.ReviewConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandsServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final ImageRepository imageRepository;

    @Transactional
    @Override
    public Review addReview(AddDto addDto) {
        Review review = ReviewConverter.toReview(addDto);
        Store store = storeRepository.findById(addDto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        review.setStore(store);
        List<Image> imageList = addDto.getImageList().stream()
                .map(url -> {
                    return Image.builder()
                            .url(url)
                            .review(review)
                            .build();
                }).collect(Collectors.toList());
        imageRepository.saveAll(imageList);
        Review saveReview = reviewRepository.save(review);

        return saveReview;
    }
}
