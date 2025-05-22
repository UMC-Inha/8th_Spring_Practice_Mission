package umc.UMC8th.service;

import umc.UMC8th.domain.Member;
import umc.UMC8th.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
