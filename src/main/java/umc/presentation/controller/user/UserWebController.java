package umc.presentation.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.application.service.user.UserCommandService;
import umc.presentation.dto.user.UserRequestDTO;

@Controller
@RequiredArgsConstructor
public class UserWebController {
    private final UserCommandService userCommandService;

    @PostMapping("/users/join")
    public String joinMember(@ModelAttribute("userJoinDto") UserRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        try{
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e){
            model.addAttribute(("error"), e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequestDTO.JoinDto());
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
}
