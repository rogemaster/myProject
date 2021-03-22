package com.project.my.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Step5Controller {

	
	@RequestMapping("/step5")
	public Map<String, Object> textGugudan(@RequestParam String dan, Model model) {
		System.out.println("dan::" + dan);
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i < 10; i++) {
			list.add(dan + " x " + i + " = " + Integer.parseInt(dan) * i);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gugudanList", list);
		
		return map;
		
		
	}
}
