package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDto;
import umc.study.web.dto.StoreResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static Store toStore(StoreRequestDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .rating(request.getRating())
                .build();
    }

    public static StoreResponseDto toStoreResponseDTO(Store store) {
        return StoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }

    public static StoreResponseDto.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .rate(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }
    public static StoreResponseDto.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        Page<StoreResponseDto.ReviewPreViewDTO> reviewPreViewDTOPage = reviewList.map(StoreConverter::reviewPreViewDTO);

        return StoreResponseDto.ReviewPreViewListDTO.builder()
                .isLast(reviewPreViewDTOPage.isLast())
                .isFirst(reviewPreViewDTOPage.isFirst())
                .totalPage(reviewPreViewDTOPage.getTotalPages())
                .totalElements(reviewPreViewDTOPage.getTotalElements())
                .listSize(reviewPreViewDTOPage.getContent().size())
                .reviewList(reviewPreViewDTOPage.getContent())
                .build();
    }

    public static StoreResponseDto.MissionListDTO toMissionListDTO(Page<Mission> missionPage) {
        List<StoreResponseDto.MissionDTO> missionList = missionPage.stream()
                .map(mission -> StoreResponseDto.MissionDTO.builder()
                        .missionId(mission.getId())
                        .missionSpec(mission.getMissionSpec())
                        .point(mission.getPoint())
                        .build())
                .toList();

        return StoreResponseDto.MissionListDTO.builder()
                .missionList(missionList)
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionList.size())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }

}