package umc.UMC8th.service;

import umc.UMC8th.domain.Member;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
