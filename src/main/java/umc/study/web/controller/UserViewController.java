package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.study.service.UserService.UserCommandService;
import umc.study.web.dto.UserRequestDto;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserCommandService userCommandService;

    @PostMapping("/users/signup")
    public String joinMember(@ModelAttribute("userJoinDto") UserRequestDto.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {
        log.info(">>> 웹 회원가입 요청 도착: {}", request);
        log.info(">>> 이름: {}", request.getName());
        log.info(">>> 이메일: {}", request.getEmail());
        log.info(">>> 비밀번호: {}", request.getPassword());
        log.info(">>> 비밀번호 null 여부: {}", request.getPassword() == null);
        log.info(">>> 바인딩 에러: {}", bindingResult.hasErrors());
        
        if (bindingResult.hasErrors()) {
            log.error(">>> 바인딩 오류: {}", bindingResult.getAllErrors());
            bindingResult.getAllErrors().forEach(error -> {
                log.error(">>> 필드: {}, 메시지: {}", error.getObjectName(), error.getDefaultMessage());
            });
            return "signup";
        }

        //System.out.println("넘어온 preferCategory: " + request.getPreferCategory());

        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            log.error(">>> 회원가입 오류: {}", e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            return "signup";
        }

    }

    @GetMapping("/login")
    public String loginPage() {
        log.info(">>> 로그인 페이지 접근");
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        log.info(">>> 회원가입 페이지 접근");
        model.addAttribute("userJoinDto", new UserRequestDto.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        log.info(">>> 홈 페이지 접근");
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        log.info(">>> 관리자 페이지 접근");
        return "admin";
    }
}

