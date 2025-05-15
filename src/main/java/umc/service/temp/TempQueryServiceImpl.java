package umc.service.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.ApiPayload.code.status.ErrorStatus;
import umc.ApiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}