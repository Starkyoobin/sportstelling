package com.sportstelling.sportsfeed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/sportsfeed")
public class FeedController {
	@GetMapping("/view")
	public String sportsfeedView(Model model) {
		return "main/sportsfeed/sportsfeed";
	}
	
	@GetMapping("/create_view")
	public String sportsfeedCreateView() {
		return "main/sportsfeed/feedcreate";
	}
}
