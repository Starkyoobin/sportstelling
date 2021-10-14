package com.sportstelling.sportsqna.comment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/sportsqna/comment")
public class CommentRestController {
	@PostMapping("/create")
	public Map<String, String> commentCreate(
			@RequestParam("id") int qnaId
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		
	}
}
