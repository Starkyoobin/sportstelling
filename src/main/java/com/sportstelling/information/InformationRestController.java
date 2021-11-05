package com.sportstelling.information;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportstelling.user.bo.UserBO;
import com.sportstelling.user.model.User;

@RestController
@RequestMapping("/main/user")
public class InformationRestController {
	@Autowired
	private UserBO signBO;
	
	//정보 변경
	@PostMapping("/update")
	public Map<String, String> updateInformation(
			@RequestParam("password") String password
			, @RequestParam("email") String email
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = signBO.updateUser(userId, password, email);
		
		Map<String, String> result = new HashMap<>();
		
		if(count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	//회원 탈퇴
//	@GetMapping("/delete")
//	public Map<String, String> deleteUser(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		int userId = (Integer)session.getAttribute("userId");
//		
//		int count = signBO.deleteUser(userId);
//		
//		Map<String, String> result = new HashMap<>();
//		
//		if(count == 1) {
//			result.put("result", "success");
//		} else {
//			result.put("result", "fail");
//		}
//		
//		return result;
//	}
}
