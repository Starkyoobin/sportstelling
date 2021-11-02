package com.sportstelling.freepost;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportstelling.freepost.bo.FreeBO;
import com.sportstelling.freepost.model.Free;
import com.sportstelling.freepost.model.FreeDetail;

@Controller
@RequestMapping("/main/freepost")
public class FreePostController {
	@Autowired
	private FreeBO freeBO;
	
	//자유게시판
	@GetMapping("/list_view")
	public String freeView(Model model) {
		List<Free> freepostList = freeBO.getFreepostList();
		
		model.addAttribute("freepostList", freepostList);
		
		return "main/freepost/list";
	}
	//자유게시판 게시판 내 글 보기
	@GetMapping("/myfreepost_view")
	public String myqnaView(
			HttpServletRequest request
			, Model model) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<Free> myFreePostList = freeBO.getFreePostListByUserId(userId);
		
		model.addAttribute("myFreePostList", myFreePostList);
		
		return "main/freepost/list";
	}
	//자유게시판 게시물 작성
	@GetMapping("/create_view")
	public String freeCreateView() {
		return "main/freepost/create";
	}
	//자유게시판 게시물 상세
	@GetMapping("/detail_view")
	public String freeDetailView(
			@RequestParam("id") int id
			, Model model) {		
		FreeDetail freeDetail = freeBO.getFreepost(id);
		
		model.addAttribute("freeDetail", freeDetail);
		
		return "main/freepost/detail";
	}
	//자유게시판 게시물 수정 / 삭제
	@GetMapping("/update_view")
	public String freeUpdateView(
			Model model
			, HttpServletRequest request
			, @RequestParam("freeId") int freeId) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Free freepost = freeBO.getFreepostByIdUserId(freeId, userId);
		
		model.addAttribute("freepost", freepost);
		
		return "main/freepost/update";
	}
}
