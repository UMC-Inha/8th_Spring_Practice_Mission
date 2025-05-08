package umc.repository.MissionRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AllArgsConstructor;
import umc.domain.QMission;
import umc.domain.QRestaurant;
import umc.domain.mapping.QUserMission;
import umc.dto.MissionDto;

@AllArgsConstructor
public class MissionRepositoryCustomImpl implements MissionRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	private final QMission mission = QMission.mission;
	private final QRestaurant restaurant = QRestaurant.restaurant;
	private final QUserMission userMission = QUserMission.userMission;

	@Override
	public List<MissionDto> findMissionsByRegionIdNotInUserMission(Long userId, Long regionId, Pageable pageable) {

		return jpaQueryFactory
			.select(Projections.constructor(MissionDto.class,
				mission.id,
				restaurant.id,
				restaurant.name,
				mission.content,
				mission.point
			))
			.from(mission)
			.join(mission.restaurant, restaurant)
			.where(
				mission.region.id.eq(regionId),
				mission.id.notIn(
					JPAExpressions
						.select(userMission.mission.id)
						.from(userMission)
						.where(userMission.user.id.eq(userId))
				)
			)
			.orderBy(mission.createdAt.desc())
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();
	}
}
