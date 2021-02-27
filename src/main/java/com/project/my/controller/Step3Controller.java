package com.project.my.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Step3Controller {
	
	static List<String> list = new ArrayList<String>();
	static int cnt = 1;
	
	@RequestMapping(value = "/step3")
	public String Step3Controller() {
		
		return "step3";
	}
	
	@RequestMapping(value = "/sessionCall")
	@ResponseBody
	public Map<String, Object> SessionCall(HttpServletRequest request) {
		
		String str = "";
		Date date = new Date();
		String sessionId = request.getRequestedSessionId();
		
		int num = cnt++;
		str = "num:" + num + " / " + "id:" + sessionId + " date:" + date;
		list.add(str);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionList", list);
		map.put("cnt", num);
		
		return map;
	}
}
