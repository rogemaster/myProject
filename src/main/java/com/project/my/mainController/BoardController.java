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
import com.project.my.mainDTO.UserSessionInfoDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlsession;

	
	@RequestMapping(value = "/list")
	public String boardListController(Model model, HttpSession session) {
		
		List<BoardDto> list = sqlsession.selectList("boardInfoMapper.getBoardList");
		model.addAttribute("list", list);
		
		return "board/list";
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
		
		UserSessionInfoDto userVO = (UserSessionInfoDto) session.getAttribute("sessionUser");
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle((String)param.get("title"));
		boardDto.setContents((String)param.get("contents"));
		boardDto.setWriter(userVO.getUserName());
		boardDto.setSessionId(userVO.getSessionId());
		int res = sqlsession.insert("boardInfoMapper.insertBoard", boardDto);
		
		return res;
	}
	
	@RequestMapping(value = "/detail")
	public String boardDetailController(@RequestParam String no, HttpSession session, Model model) {
		
		if(session.getAttribute("sessionUser") == null) {
			return "redirect:/login";
			
		}else {
			
			BoardDto boardDto = sqlsession.selectOne("boardInfoMapper.getBoardDetail", Integer.parseInt(no));
			model.addAttribute("boardDetail", boardDto);
			
			return "board/detail";
		}
	}
	
	@RequestMapping(value = "/modify")
	public String boardModifyController(@RequestParam String no, HttpSession session, Model model) {
		
		if(session.getAttribute("sessionUser") == null) {
			return "redirect:/login";
		}else {
			
			BoardDto boardDto = sqlsession.selectOne("boardInfoMapper.getBoardDetail", Integer.parseInt(no));
			model.addAttribute("boardContents", boardDto);
			
			return "board/modify";
		}
	}
	
	
}
