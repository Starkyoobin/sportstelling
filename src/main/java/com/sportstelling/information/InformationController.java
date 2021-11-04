package com.sportstelling.information;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstelling.user.bo.UserBO;
import com.sportstelling.user.model.User;

@Controller
@RequestMapping("/main")
public class InformationController {
	@Autowired
	private UserBO signBO;
	
	//회원정보 변경 화면
	@GetMapping("/update_view")
	public String userUpdateView(
			Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("userLoginId");
		session.removeAttribute("email");
		
		User user = signBO.getUserInformation(loginId);
		session.setAttribute("email", user.getEmail());
		
		model.addAttribute("user", user);
		
		return "sign/update";
	}
}
