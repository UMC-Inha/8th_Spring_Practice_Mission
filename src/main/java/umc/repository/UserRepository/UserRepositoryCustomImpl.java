package umc.repository.UserRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;
import umc.domain.QUser;
import umc.dto.MyPageDto;

@AllArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	private final QUser user = QUser.user;

	@Override
	public MyPageDto findMyPageByUserId(Long id) {

		return jpaQueryFactory
			.select(Projections.constructor(
				MyPageDto.class,
				user.id,
				user.name,
				user.email,
				user.point,
				user.profileImage,
				user.phoneNumber
				)
			)
			.from(user)
			.where(user.id.eq(id))
			.fetchOne();
	}
}
