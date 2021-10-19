package com.sportstelling.sportsqna.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportstelling.sportsqna.comment.bo.QnACommentBO;

@RestController
@RequestMapping("/main/sportsqna/comment")
public class QnACommentRestController {
	@Autowired
	private QnACommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, String> qnaCommentCreate(
			@RequestParam("qnaId") int qnaId
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		int count = commentBO.addComment(qnaId, userId, userNickName, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
