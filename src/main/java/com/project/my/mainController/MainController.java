package com.project.my.mainController;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.my.mainDTO.UserDto;

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
	
	@RequestMapping(value = "/loginAccess", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginController(@RequestParam Map<String, Object> param) {
		
		UserDto userDto = sqlsession.selectOne("userInfoMapper.getUserInfo", param.get("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(userDto == null) {
			map.put("result", "error");
			return map;
		}else {
			if(!param.get("pw").equals(userDto.getPw())) {
				map.put("result", "pwError");
				return map;
			}else {
				map.put("result", "ok");
				return map;
			}
		}
	}

}
