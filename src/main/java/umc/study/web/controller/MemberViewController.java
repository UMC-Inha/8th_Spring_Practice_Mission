package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.study.service.member.MemberCommandService;
import umc.study.web.controller.member.dto.MemberRequestDTO;
import umc.study.repository.food.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;
    private final CategoryRepository categoryRepository;

    @PostMapping("/members/signup")
    @Operation(summary = "회원가입 폼 제출", description = "Thymeleaf 기반 회원가입 폼 데이터를 처리합니다.")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }


    @GetMapping("/login")
    @Operation(summary = "로그인 페이지", description = "로그인 폼을 반환합니다.")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    @Operation(summary = "회원가입 페이지", description = "회원가입 폼을 반환합니다.")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        model.addAttribute("categories", categoryRepository.findAll());
        return "signup";
    }

    @GetMapping("/home")
    @Operation(summary = "홈 페이지", description = "홈 화면을 반환합니다.")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    @Operation(summary = "관리자 페이지", description = "관리자 화면을 반환합니다.")
    public String admin() {
        return "admin";
    }
}
