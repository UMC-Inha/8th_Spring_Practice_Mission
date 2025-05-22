package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.MissionResponseDto;

import java.util.List;

@Repository
public interface UserMissionRepositoryCustom {
    //List<UserMission> findByMemberId(Long memberId);
    //List<UserMission> findChallengingMissionByUser(Long UserId, Pageable pageable);
    //List<MissionResponseDto> findCompletedMissionByUser(Long UserId, Pageable pageable);
    //Long countCompletedMissionByUser(Long UserId, String regionName);
}
