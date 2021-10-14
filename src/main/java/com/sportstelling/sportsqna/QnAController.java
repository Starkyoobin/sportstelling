package com.sportstelling.sportsqna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstelling.sportsqna.bo.QnABO;
import com.sportstelling.sportsqna.model.QnA;

@Controller
@RequestMapping("/main/sportsqna")
public class QnAController {
	@Autowired
	private QnABO qnaBO;
	
	@GetMapping("/list_view")
	public String qnaView(Model model) {
		List<QnA> qnaList = qnaBO.getQnAList();
		
		model.addAttribute("qnaList", qnaList);
		
		return "main/sportsqna/list";
	}
	
	@GetMapping("create_view")
	public String qnaCreateView() {
		return "main/sportsqna/create";
	}
}
