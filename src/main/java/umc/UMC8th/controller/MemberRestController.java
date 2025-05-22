package umc.UMC8th.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.UMC8th.apiPayload.ApiResponse;
import umc.UMC8th.converter.MemberConverter;
import umc.UMC8th.domain.Member;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.dto.MemberResponseDTO;
import umc.UMC8th.service.MemberCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDto> join(
            @RequestBody @Valid MemberRequestDTO.JoinDto request) {

        Member savedMember = memberCommandService.joinMember(request);


        return ApiResponse.onSuccess(
                MemberConverter.toJoinResultDto(
                        savedMember,
                        request.getFoodCategories().toString() // List<Long> → String으로 변환
                )
        );
    }
}