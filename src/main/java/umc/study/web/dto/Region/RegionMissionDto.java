package umc.study.web.dto.Region;


import java.time.LocalDate;

public record RegionMissionDto(
        Long missionId,
        String missionSpec,
        Integer reward,
        LocalDate deadline,
        String storeName
) {}