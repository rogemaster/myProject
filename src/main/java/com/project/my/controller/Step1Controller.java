package com.project.my.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Step1Controller {
	
	@RequestMapping(value = "/step1")
	public String Step1Controller() {
		
		return "step1";
	}
	
	@RequestMapping(value = "/gugudancalcul")
	@ResponseBody
	public Map<String, Object> Step1GugudanCalculate(@RequestParam String dan) {
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
