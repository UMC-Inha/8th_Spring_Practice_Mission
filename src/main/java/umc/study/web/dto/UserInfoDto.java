package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
    private String name;
    private String email;
    private Integer points;
    private String phoneNumber;
}
