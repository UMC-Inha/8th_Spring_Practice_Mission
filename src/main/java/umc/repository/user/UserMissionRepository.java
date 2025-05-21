package umc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.Mission;
import umc.domain.User;
import umc.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Boolean existsUserMissionByUserAndMission(User user, Mission mission);

}
