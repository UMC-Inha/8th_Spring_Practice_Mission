package umc.UMC8th.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.UMC8th.repository.MemberMissionRepository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MissionValidationService {

    private final MemberMissionRepository memberMissionRepository;

    public boolean isAlreadyChallenging(Long memberId, Long missionId) {
        return memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}