package com.project.my.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Step4Controller {

	@RequestMapping(value = "/step4")
	public String Step4Controller() {
		
		return "step4";
	}
	
	@RequestMapping(value = "/ajaxcall", method = RequestMethod.POST)
	@ResponseBody
	public void AjaxDataCall(@RequestBody List<userInfo> userInfo) throws Exception {
		
		System.out.println("USERINFO :: " + userInfo.toString());
		for(int i = 0; i < userInfo.size(); i++) {
			System.out.println("USER :: " + userInfo.get(i));
		}
		System.out.println("SIZE :: " + userInfo.size());
		
		
	}
}
