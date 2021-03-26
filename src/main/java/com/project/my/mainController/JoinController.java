package com.project.my.mainController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {

	@RequestMapping(value = "/authSendMail", method = RequestMethod.POST)
	public String authSendMail(@RequestParam String param, HttpSession session) {
		System.out.println("Email :: " + param);
		
		MailSendController msc = new MailSendController();
		Map<String, Object> resMail = msc.sendMailController(param);
		
		if(resMail.get("res").equals("success")) {
			session.setAttribute("authCode", resMail.get("authCode"));
			return "success";
		}else {
			return "fail";
		}
	}
}
