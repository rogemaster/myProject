package com.project.my.mainController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendController {
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	public Map<String, Object> sendMailController(String param) {
		System.out.println("sendMailController :: " + param);
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		String authCode = UUID.randomUUID().toString().split("-")[0];
		Map<String, Object> map = new HashMap<String, Object>();
		
		String subject = "인증 번호 입니다.";
		String content = "전달 드린 인증번호를 가입페이지에 기입하시고 회원가입을 진행하시기 바랍니다.<br>"
						+ "인증번호 : " + authCode;
		
		String from = "rlaaudwn000@gmail.com";
		
		String to = param;
		
		try {
			System.out.println("mailSender?? " + mailSender);
			
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
			
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content);
			
			mailSender.send(mail);
			
			map.put("authCode", authCode);
			map.put("res", "success");
			
			return map;
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("res", "fail");
			return map;
		}
		
	}

}
