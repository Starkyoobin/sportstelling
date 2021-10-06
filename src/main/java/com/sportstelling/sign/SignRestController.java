package com.sportstelling.sign;

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

import com.sportstelling.sign.bo.SignBO;
import com.sportstelling.sign.model.Sign;

@RestController
@RequestMapping("/sign")
public class SignRestController {
	@Autowired
	private SignBO signBO;
	
	@PostMapping("/up")
	public Map<String, String> signUp(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("nickName") String nickName
			, @RequestParam("email") String email) {
		int count = signBO.addSign(loginId, password, name, nickName, email);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/is_duplicate_id")
	public Map<String, Boolean> isDuplicateLoginId(@RequestParam("loginId") String loginId) {
		Map<String, Boolean> result = new HashMap<>();
		
		if(signBO.isDuplicateId(loginId)) {
			result.put("is_duplicate_id", true);
		} else {
			result.put("is_duplicate_id", false);
		}
		
		return result;
	}
	
	@GetMapping("/is_duplicate_nickname")
	public Map<String, Boolean> isDuplicateNickName(@RequestParam("nickName") String nickName) {
		Map<String, Boolean> result = new HashMap<>();
		
		if(signBO.isDuplicateNickName(nickName)) {
			result.put("is_duplicate_nickname", true);
		} else {
			result.put("is_duplicate_nickname", false);
		}
		
		return result;
	}
	
	@PostMapping("/in")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		Sign user = signBO.getSign(loginId, password);
				
		Map<String, String> result = new HashMap<>();
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userNickName", user.getNickName());
			
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
