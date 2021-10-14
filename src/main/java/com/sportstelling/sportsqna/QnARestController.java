package com.sportstelling.sportsqna;

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

import com.sportstelling.sportsqna.bo.QnABO;

@RestController
@RequestMapping("/main/sportsqna")
public class QnARestController {
	@Autowired
	private QnABO qnaBO;
	
	@PostMapping("/create")
	public Map<String, String> qnaCreate(
			@RequestParam("subject") String subject
			, @RequestParam(value = "file", required = false) MultipartFile file
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		int count = qnaBO.addQnA(userId, userNickName, subject, file, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
