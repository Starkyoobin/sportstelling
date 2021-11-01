package com.sportstelling.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportstelling.user.bo.UserBO;
import com.sportstelling.user.model.User;

@Controller
@RequestMapping("/sign")
public class UserController {
	@Autowired
	private UserBO signBO;
	
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
		session.removeAttribute("email");
		
		return "redirect:/sign/in_view";
	}	
}
