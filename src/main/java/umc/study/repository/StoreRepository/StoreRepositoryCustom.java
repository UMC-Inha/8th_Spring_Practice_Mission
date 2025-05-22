package umc.study.repository.StoreRepository;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.domain.Store;

import java.math.BigDecimal;
import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, BigDecimal rating);
}