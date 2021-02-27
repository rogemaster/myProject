package com.project.my.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Step2Controller {

	@RequestMapping(value = "/step2")
	public String Step2Controller(Model model) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("student1 : male");
		list.add("student2 : male");
		list.add("student3 : male");
		
		model.addAttribute("jstlList", list);
		
		return "step2";
	}
}
