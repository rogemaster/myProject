package com.project.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JqueryStep1Controller {

	
	@RequestMapping(value = "/htmlstep1")
	public String JqueryStepController() {
		
		return "step1/step1";
	}
}
