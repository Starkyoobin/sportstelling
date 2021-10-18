package com.sportstelling.freepost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportstelling.freepost.bo.FreeBO;
import com.sportstelling.freepost.model.Free;

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
		Free freepost = freeBO.getFreepost(id);
		
		model.addAttribute("freepost", freepost);
		
		return "main/freepost/detail";
	}
}
