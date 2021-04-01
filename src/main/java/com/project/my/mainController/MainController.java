package com.project.my.mainController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.my.mainDTO.UserDto;
import com.project.my.mainDTO.UserSessionInfoDto;

@Controller
public class MainController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping(value = "/main")
	public String MainPageController() {
		return "main";
	}
	
	@RequestMapping(value = "/login")
	public String LoginPageController() {
		return "login";
	}
	
	@RequestMapping(value = "/join")
	public String JoinPageController() {
		return "join";
	}
	
	UserDto userDto = new UserDto();
	UserSessionInfoDto userSessionInfoDto = new UserSessionInfoDto();
	
	@RequestMapping(value = "/loginAccess", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginController(@RequestParam Map<String, Object> param, HttpServletRequest request) {
		
		userDto = sqlsession.selectOne("userInfoMapper.getUserInfo", param.get("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(userDto == null) {
			map.put("result", "error");
			return map;
		}else {
			if(!param.get("pw").equals(userDto.getPw())) {
				map.put("result", "pwError");
				return map;
			}else {
				map.put("result", SessionChk(request));
				return map;
			}
		}
	}
	
	public String SessionChk(HttpServletRequest request) {
		
		String sId = request.getSession().getId();
		
		if(userSessionInfoDto.getSessionId() == null) {
			HttpSession session = request.getSession();
			userSessionInfoDto.setUserId(userDto.getId());
			userSessionInfoDto.setUserName(userDto.getName());
			userSessionInfoDto.setSessionId(request.getSession().getId());
			session.setAttribute("sessionUser", userSessionInfoDto);
			
			return "ok";
			
		}else if(sId.equals(userSessionInfoDto.getSessionId())) {
			return "ok";
			
		}else {
			return "fail";
			
		}
		
	}
	
	@RequestMapping(value = "/logout")
	public String logoutController(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
