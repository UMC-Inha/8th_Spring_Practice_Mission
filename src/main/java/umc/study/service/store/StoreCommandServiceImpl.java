package umc.study.service.store;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Image;
import umc.study.domain.region.Region;
import umc.study.domain.store.Store;
import umc.study.repository.image.ImageRepository;
import umc.study.repository.region.RegionRepository;
import umc.study.repository.store.StoreRepository;
import umc.study.web.controller.store.dto.StoreRequestDTO.AddDto;
import umc.study.web.converter.store.StoreConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ImageRepository imageRepository;

    @Transactional
    @Override
    public Store addStore(AddDto addDto) {
        Store store = StoreConverter.toStore(addDto);
        Region region = regionRepository.findById(addDto.getRegionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);
        List<Image> imageList = addDto.getImageList().stream()
                .map(url -> {
                    return Image.builder()
                            .url(url)
                            .store(store)
                            .build();
                }).collect(Collectors.toList());
        imageRepository.saveAll(imageList);
        Store saveStore = storeRepository.save(store);
        return saveStore;
    }
}
