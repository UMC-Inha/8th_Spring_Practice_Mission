package umc.study.dto;


import java.time.LocalDate;

public record RegionMissionDto(
        Long missionId,
        String missionSpec,
        Integer reward,
        LocalDate deadline,
        String storeName
) {}