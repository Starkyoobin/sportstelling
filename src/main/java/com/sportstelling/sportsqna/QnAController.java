package com.sportstelling.sportsqna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/sportsqna")
public class QnAController {
	@GetMapping("/list_view")
	public String qnaView() {
		return "main/sportsqna/list";
	}
}
