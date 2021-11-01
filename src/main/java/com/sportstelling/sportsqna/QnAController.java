package com.sportstelling.sportsqna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportstelling.sportsqna.bo.QnABO;
import com.sportstelling.sportsqna.model.QnA;
import com.sportstelling.sportsqna.model.QnADetail;

@Controller
@RequestMapping("/main/sportsqna")
public class QnAController {
	@Autowired
	private QnABO qnaBO;
	//스포츠Q&A 게시판
	@GetMapping("/list_view")
	public String qnaView(Model model) {
		List<QnA> qnaList = qnaBO.getQnAList();
		
		model.addAttribute("qnaList", qnaList);
		
		return "main/sportsqna/list";
	}
	//스포츠Q&A 게시판 내 글 보기
	@GetMapping("/myqna_view")
	public String myqnaView(
			HttpServletRequest request
			, Model model) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<QnA> myqnaList = qnaBO.getQnAListByUserId(userId);
		
		model.addAttribute("myqnaList", myqnaList);
		
		return "main/sportsqna/list";
	}
	//스포츠Q&A 게시물 작성
	@GetMapping("/create_view")
	public String qnaCreateView() {
		return "main/sportsqna/create";
	}
	//스포츠Q&A 게시물 상세
	@GetMapping("/detail_view")
	public String qnaDetailView(
			@RequestParam("id") int id
			, Model model) {
		QnADetail qnaDetail = qnaBO.getQnA(id);
		
		model.addAttribute("qnaDetail", qnaDetail);
		
		return "main/sportsqna/detail";
	}
	//스포츠Q&A 게시물 수정 / 삭제
	@GetMapping("update_view")
	public String qnaUpdateView(
			@RequestParam("qnaId") int qndId
			, Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		QnA qna = qnaBO.getQnAByIdUserId(qndId, userId);
		
		model.addAttribute("qna", qna);
		
		return "main/sportsqna/update";
	}
}
