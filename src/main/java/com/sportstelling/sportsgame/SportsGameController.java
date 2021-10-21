package com.sportstelling.sportsgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportstelling.sportsgame.bo.SportsBO;

@Controller
@RequestMapping("/main/sportsgame")
public class SportsGameController {
	@Autowired
	private SportsBO sportsBO;
	@ResponseBody
	@GetMapping("/view")
	public String sportsgameView() {
		String sports = sportsBO.getSportsGame();
		return sports;
//		model.addAttribute();
//		
//		return "main/sportsgame";
	}
}
