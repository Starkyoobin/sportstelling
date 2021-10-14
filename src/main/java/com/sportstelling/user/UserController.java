package com.sportstelling.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class UserController {
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
	//로그아웃
	@GetMapping("/out")
	public String signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		session.removeAttribute("userNickName");
		
		return "redirect:/sign/in_view";
	}
	//유저 정보
	@GetMapping("/user/update_view")
	public String userUpdateView() {
		return "sign/update";
	}
}
