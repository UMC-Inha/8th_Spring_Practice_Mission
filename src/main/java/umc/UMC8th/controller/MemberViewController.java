package umc.UMC8th.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.UMC8th.dto.MemberRequestDTO;
import umc.UMC8th.service.MemberCommandService;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") @Valid MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {
        System.out.println("POST /members/signup 진입함");
        if (bindingResult.hasErrors()) {
            System.out.println("바인딩 에러 발생: " + bindingResult.getAllErrors());
            return "signup";
        }

        try {
            memberCommandService.joinMember(request); // 실제 회원가입 로직 호출
            return "redirect:/login"; // 성공 시 로그인 페이지로 이동
        } catch (Exception e) {
            System.out.println("회원가입 중 예외 발생: " + e.getMessage());
            model.addAttribute("error", e.getMessage()); // 실패 시 에러 메시지 표시
            return "signup"; // 다시 회원가입 폼 보여줌
        }
    }
}
