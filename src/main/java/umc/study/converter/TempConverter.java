package umc.study.converter;

import umc.study.web.dto.TempRequest;
import umc.study.web.dto.TempResponse;
import umc.study.web.dto.TempResponse.TempExceptionDTO;
import umc.study.web.dto.TempResponse.TempTestDTO;

public class TempConverter {

    public static TempTestDTO toTempTestDTO() {
        return TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
