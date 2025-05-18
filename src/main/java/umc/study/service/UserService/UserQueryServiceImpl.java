package umc.study.service.UserService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

}
