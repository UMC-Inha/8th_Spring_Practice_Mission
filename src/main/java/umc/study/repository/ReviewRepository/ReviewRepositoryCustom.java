package umc.study.repository.ReviewRepository;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface ReviewRepositoryCustom {
    public Long save(User user, Store store, String content, BigDecimal rating);
}
