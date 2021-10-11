package com.sportstelling.sportsfeed;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.sportsfeed.bo.PostBO;

@RestController
@RequestMapping("/main/sportsfeed")
public class FeedRestController {
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, String> sportsfeedCreate(
			@RequestParam(value = "file") MultipartFile file
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		int count = postBO.addPost(userId, userNickName, file, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
