package umc.study.service.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.member.Member;
import umc.study.domain.store.Store;
import umc.study.web.controller.store.dto.StoreReponseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    //메서드 반환 타입이 Optional일 경우 이 메서드는 null을 반환할 수도 있다고 생각
    //아래 메서드는 Store가 존재하지 않을 수 있기에 Optional 사용
    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, BigDecimal score);

    Page<StoreReponseDTO.ReviewPreViewDTO> getReviewList(Long storeId, Pageable pageable, Member member);
}
