package umc.persistence.repository.user;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.entity.user.QUser;
import umc.presentation.dto.user.UserProfileDto;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final JpaUserRepository jpaUserRepository;
    private final QUser qUser = QUser.user;
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public UserProfileDto getUserProfile(Long userId){
        return jpaQueryFactory
                .select(Projections.constructor(UserProfileDto.class,
                        qUser.email,
                        qUser.name,
                        qUser.point,
                        new CaseBuilder()
                                .when(qUser.phoneAuth.eq(false))
                                .then("미인증")
                                .otherwise(qUser.phoneNum)
                ))
                .from(qUser)
                .where(qUser.id.eq(userId))
                .fetchOne();
    }
}
