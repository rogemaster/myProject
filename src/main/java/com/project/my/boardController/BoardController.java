package com.project.my.boardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	
	@RequestMapping("/board")
	public String boardListController() {
		
		return "board/list";
	}
}
