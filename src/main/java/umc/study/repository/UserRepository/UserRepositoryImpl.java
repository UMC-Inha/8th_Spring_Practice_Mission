/*package umc.study.repository.UserRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QUser;
import umc.study.web.dto.UserRequestDto;
import umc.study.web.dto.UserResponseDto;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QUser user = QUser.user;


    @Override
    public UserRequestDto findUserInfoById(Long userId) {
        return queryFactory
                .select(Projections.constructor(UserResponseDto.class,
                        user.name,
                        user.email,
                        user.phoneNumber,
                        user.point,
                        user.address
                ))
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();
    }
}*/