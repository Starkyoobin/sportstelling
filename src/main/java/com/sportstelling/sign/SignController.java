package com.sportstelling.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController {
	//로그인 화면
	@GetMapping("/in_view")
	public String signinView() {
		return "sign/in";
	}
	//회원가입 화면
	@GetMapping("/up_view")
	public String signupView() {
		return "sign/up";
	}
	//아이디 / 비밀번호 찾기
	@GetMapping("/find_view")
	public String signfindView() {
		return "sign/find";
	}
}
