package com.sportstelling.sportsgame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/sportsgame")
public class SportsGameController {
	@GetMapping("/view")
	public String sportsgameView() {
		return "main/sportsgame";
	}
}
