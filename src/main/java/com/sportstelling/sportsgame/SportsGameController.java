package com.sportstelling.sportsgame;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportstelling.sportsgame.bo.SportsBO;

@Controller
@RequestMapping("/main/sportsgame")
public class SportsGameController {
	@Autowired
	private SportsBO sportsBO;
	
	@GetMapping("/view")
	public String sportsgameView(Model model) throws URISyntaxException {
		List<Object> sports = sportsBO.getSportsGame();
		
		model.addAttribute("sports", sports);
		
		return "main/sportsgame";
	}
}
