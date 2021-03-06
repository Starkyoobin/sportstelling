package com.sportstelling.freepost;

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
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.freepost.bo.FreeBO;

@RestController
@RequestMapping("/main/freepost")
public class FreePostRestController {
	@Autowired
	private FreeBO freeBO;
	
	//게시물 작성
	@PostMapping("/create")
	public Map<String, String> freepostCreate(
			@RequestParam("subject") String subject
			, @RequestParam(value = "file", required = false) MultipartFile file
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNickName = (String)session.getAttribute("userNickName");
		
		int count = freeBO.addFreepost(userId, userNickName, subject, file, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	//게시물 수정
	@PostMapping("/update")
	public Map<String, String> updateQnA(
			@RequestParam("id") int id
			, @RequestParam("subject") String subject
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> result = new HashMap<>();
		
		int count = freeBO.updateFreepost(id, userId, subject, content);
		
		if(count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	//게시물 삭제
	@GetMapping("/delete")
	public Map<String, String> deleteQnA(
			@RequestParam("id") int id
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = freeBO.deleteFreepost(id, userId);
		
		Map<String, String> result = new HashMap<>();
		
		if(count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
