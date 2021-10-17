package com.sportstelling.freepost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/freepost")
public class FreePostController {
	//자유게시판
	@GetMapping("/list_view")
	public String freeView() {
		return "main/freepost/list";
	}
	//자유게시판 게시물 작성
	@GetMapping("/create_view")
	public String createView() {
		return "main/freepost/create";
	}
}
