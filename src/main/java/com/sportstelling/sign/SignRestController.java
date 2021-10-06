package com.sportstelling.sign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportstelling.sign.bo.SignBO;

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
}
