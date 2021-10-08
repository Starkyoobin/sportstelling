package com.sportstelling.sportsfeed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/sportsfeed")
public class FeedController {
	@GetMapping("/view")
	public String sportsfeedView() {
		return "main/sportsfeed/sportsfeed";
	}
}
