package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.UserMission;

import java.util.List;

@Repository
public interface UserMissionRepositoryCustom {
    //List<UserMission> findByMemberId(Long memberId);
    List<UserMission> findChallengingMissionByUser(Long UserId, Pageable pageable);
    List<UserMission> findCompletedMissionByUser(Long UserId, Pageable pageable);
    Long countCompletedMissionByUser(Long UserId, String regionName);
}
