package umc.study.web.dto;

public class UserMissionResponseDto {
    private Long missionId;
    private String missionName;
    private String storeName;

    public UserMissionResponseDto(Long missionId, String missionName, String storeName) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.storeName = storeName;
    }
}
