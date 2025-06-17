package umc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import umc.dto.UserRequestDto;
import umc.service.UserService.UserCommandService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserViewController {

	private final UserCommandService userCommandService;

	/*
	@PostMapping("/signup")
	public String joinUser(@ModelAttribute("joinDto") UserRequestDto.JoinDto request,
		BindingResult bindingResult,
		Model model) {
		if (bindingResult.hasErrors()) {
			return "/signup";
		}
		try {
			userCommandService.joinUser(request);
			return "redirect:/login";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "/signup";
		}
	}
	*/

	@GetMapping("/login")
	public String loginPage() {
		return "/login";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("joinDto", new UserRequestDto.JoinDto());
		return "signup";
	}
}
