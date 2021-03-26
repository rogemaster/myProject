package com.project.my.mainController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.my.mainDTO.BoardDto;
import com.project.my.mainDTO.UserSessionInfoVO;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlsession;

	
	@RequestMapping(value = "/list")
	public String boardListController(Model model, HttpSession session) {
		
		if(session.getAttribute("sessionUser") == null) {
			return "redirect:/login";
			
		}else {
			
			List<BoardDto> list = sqlsession.selectList("boardInfoMapper.getBoardList");
			System.out.println("board list :: " + list.toString());
			
			model.addAttribute("list", list);
			
			return "board/list";
			
		}
		
	}
	
	@RequestMapping("/insert")
	public String insertBoardPage(HttpSession session) {
		
		if(session.getAttribute("sessionUser") == null) {
			return "redirect:/login";
			
		}else {
			return "board/insert";
			
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public int boardContentsSave(@RequestParam Map<String, Object> param, HttpSession session) {
		
		System.out.println("sava param:: " + param);
		System.out.println(session.getAttribute("sessionUser").toString());
		
		UserSessionInfoVO userVO = (UserSessionInfoVO) session.getAttribute("sessionUser");
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle((String)param.get("title"));
		boardDto.setContents((String)param.get("contents"));
		boardDto.setWriter(userVO.getUserName());
		boardDto.setSessionId(userVO.getSessionId());
		int res = sqlsession.insert("boardInfoMapper.insertBoard", boardDto);
		
		return res;
	}
}
