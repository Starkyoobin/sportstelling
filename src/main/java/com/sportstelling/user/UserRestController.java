package com.sportstelling.user;

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

import com.sportstelling.email.bo.EmailBO;
import com.sportstelling.email.dto.EmailDto;
import com.sportstelling.user.bo.UserBO;
import com.sportstelling.user.model.User;

@RestController
@RequestMapping("/sign")
public class UserRestController {
	@Autowired
	private UserBO signBO;
	@Autowired
	private EmailBO mailBO;
	//회원가입
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
	//아이디 중복체크
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
	//닉네임 중복체크
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
	//로그인
	@PostMapping("/in")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		User user = signBO.getSign(loginId, password);
				
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
	//아이디 찾기
	@PostMapping("/find_id")
	public Map<String, String> loginIdFind(
			@RequestParam("name") String name
			, @RequestParam("email") String email) {
		User user = signBO.getId(name, email);
		
		Map<String, String> result = new HashMap<>();
		
		if(user != null) {
			String loginId = user.getLoginId();
			
			if(user.getLoginId() != null) {
				result.put("result", "success");
				result.put("loginId", loginId);
			} else {
				result.put("result", "fail");
			}
		}
		
		return result;
	} 
	//비밀번호 찾기 (loginId, email 일치여부)
	@PostMapping("/find_password")
	public Map<String, Boolean> passwordFind(
			@RequestParam("loginId") String loginId
			, @RequestParam("email") String email) {
		Map<String, Boolean> result = new HashMap<>();
		
		if(signBO.getPassword(loginId, email)) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		
		return result;
	}
	//임시 비밀번호 생성하고 이메일로 보낸뒤 임시 비밀번호로 유저 pw를 바꾸기
	public void sendEmail(String loginId, String email) {
		EmailDto dto = mailBO.sendMailAndChangePassword(loginId, email);
		
	}
}
