package umc.study.web.converter.member;

import umc.study.domain.enums.Gender;
import umc.study.domain.member.Member;
import umc.study.web.controller.member.dto.MemberRequestDTO;
import umc.study.web.controller.member.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;

import static umc.study.web.controller.member.dto.MemberResponseDTO.*;

public class MemberConverter {
    public static JoinResultDTO toJoinResultDTO(Member member) {
        return JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        return Member.builder()
                .birth(request.getBirth())
                .address(request.getAddress())
                .password(request.getPassword())
                .role(request.getRole())
                .gender(request.getGender())
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member) {
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender() != null ? member.getGender().name() : null)
                .build();
    }

}
