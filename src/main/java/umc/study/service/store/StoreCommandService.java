package umc.study.service.store;

import umc.study.domain.store.Store;
import umc.study.web.dto.request.StoreRequestDto;

// 쓰기 책임만 담당하는 서비스
// 상태 변경 작업을 담당
public interface StoreCommandService {

    Store registerStore(StoreRequestDto.RegisterDto request);
}
