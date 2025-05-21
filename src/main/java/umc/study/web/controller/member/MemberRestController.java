package umc.study.web.controller.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.service.member.MemberCommandServiceImpl;
import umc.study.web.converter.member.MemberConverter;

import static umc.study.web.controller.member.dto.MemberRequestDTO.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandServiceImpl memberCommandService;

    // 회원가입
    @PostMapping("/")
    public ResponseEntity<?> join(@RequestBody @Valid JoinDto request) {
        return ResponseEntity.ok(MemberConverter.toJoinResultDTO(memberCommandService.joinMember(request)));
    }
}
