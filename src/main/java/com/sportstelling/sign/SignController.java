package com.sportstelling.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController {
	@GetMapping("/in_view")
	public String signinView() {
		return "sign/in";
	}
	
	@GetMapping("/up_view")
	public String signupView() {
		return "sign/up";
	}
}
