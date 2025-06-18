package umc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;// thymeleaf 사용을 위해 일부가 변경되었습니다.
import umc.service.user.UserCommandService;
import umc.web.dto.user.UserRequestDTO;

// 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
@RequiredArgsConstructor
public class UserViewController{

    private UserCommandService userCommandService;

    @PostMapping("/users/signup-form")
    public String joinMember(@ModelAttribute("memberJoinDto") UserRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            return "signup";
        }

        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
}