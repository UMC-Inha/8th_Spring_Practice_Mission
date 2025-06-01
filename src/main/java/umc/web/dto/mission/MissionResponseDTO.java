package umc.web.dto.mission;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.Location;
import umc.domain.Restaurant;
import umc.web.dto.review.ReviewResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListDTO{
        List<MissionResponseDTO.MissionDTO> missionDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionDTO{
        String missionName;
        String contents;
        Integer points;
        Long restaurantId;
        LocalDate createdAt;
    }


}
