package com.sportstelling.sportsfeed.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportstelling.sportsfeed.like.bo.LikeBO;

@RestController
@RequestMapping("/main/sportsfeed")
public class LikeRestController {
	@Autowired
	private LikeBO likeBO;
	
	@GetMapping("/like")
	public Map<String, String> feedLike(
			@RequestParam("postId") int postId
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		Map<String, String> result = new HashMap<>();
		
		boolean isLike = likeBO.addLike(userId, postId, userNickName);
		
		if(isLike) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
