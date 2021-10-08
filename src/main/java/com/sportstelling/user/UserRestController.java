package com.sportstelling.user;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportstelling.user.bo.UserBO;
import com.sportstelling.user.model.User;

@RestController
@RequestMapping("/sign")
public class UserRestController {
	@Autowired
	private UserBO signBO;
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
	//임시비밀번호 생성
	public String getRandomPassword(int size) {
		int index = 0;
		char[] charArray = new char[] {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'!', '@', '#', '$', '%', '^', '&'
		};
		
		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		int len = charArray.length;
		
		for(int i = 0; i < size; i++) {
			index = sr.nextInt(len);
			sb.append(charArray[index]);
		}
		
		return sb.toString();
	}
	//임시 비밀번호 변경
	public void updateRandomPassword() {
		String randomPassword = this.getRandomPassword(10);
		
		int count = signBO.changePassword(randomPassword);
	}
	//비밀번호 찾기
	@PostMapping("/find_password")
	public Map<String, String> passwordFind(
			@RequestParam("loginId") String loginId
			, @RequestParam("email") String email) {
		int count = signBO.getPassword(loginId, email);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
