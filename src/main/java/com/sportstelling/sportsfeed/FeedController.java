package com.sportstelling.sportsfeed;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstelling.sportsfeed.bo.PostBO;
import com.sportstelling.sportsfeed.model.PostDetail;

@Controller
@RequestMapping("/main/sportsfeed")
public class FeedController {
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/view")
	public String sportsfeedView(
			Model model
			, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<PostDetail> postList = postBO.getPostList(userId);
		
		model.addAttribute("postList", postList);
		
		return "main/sportsfeed/sportsfeed";
	}
	
	@GetMapping("/create_view")
	public String sportsfeedCreateView() {
		return "main/sportsfeed/feedcreate";
	}
}
