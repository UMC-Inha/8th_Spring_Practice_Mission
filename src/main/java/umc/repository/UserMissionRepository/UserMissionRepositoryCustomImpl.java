package umc.repository.UserMissionRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;
import umc.domain.QMission;
import umc.domain.QRegion;
import umc.domain.QRestaurant;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.QUserMission;
import umc.dto.MissionDto;

@AllArgsConstructor
public class UserMissionRepositoryCustomImpl implements UserMissionRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	private final QUserMission userMission = QUserMission.userMission;
	private final QMission mission = QMission.mission;
	private final QRestaurant restaurant = QRestaurant.restaurant;
	private final QRegion region = QRegion.region;

	@Override
	public List<MissionDto> findMissionByUserIdAndStatus(Long userId, MissionStatus status, Pageable pageable) {

		return jpaQueryFactory
			.select(Projections.constructor(
				MissionDto.class,
				mission.id,
				restaurant.id,
				restaurant.name,
				mission.content,
				mission.point)
			)
			.from(userMission)
			.join(userMission.mission, mission)
			.join(mission.restaurant, restaurant)
			.where(
				userIdEq(userId),
				statusEq(status)
			)
			.orderBy(userMission.mission.deadline.asc())
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();
	}

	@Override
	public Long countCompletedMissionByUserIdAndRegion(Long userId, String regionName) {

		return jpaQueryFactory
			.select(userMission.count())
			.from(userMission)
			.join(userMission.mission, mission)
			.join(mission.region, region)
			.where(
				userIdEq(userId),
				statusEq(MissionStatus.COMPLETED),
				region.name.eq(regionName)
			)
			.fetchOne();
	}

	private BooleanExpression userIdEq(Long userId) {
		return userId != null ? userMission.user.id.eq(userId) : null;
	}

	private BooleanExpression statusEq(MissionStatus status) {
		return status != null ? userMission.status.eq(status) : null;
	}
}
