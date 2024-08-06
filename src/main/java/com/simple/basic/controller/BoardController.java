package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.basic.command.BoardDTO;
import com.simple.basic.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("BoardService")
	private BoardService boardService;
	
//	@RequestMapping("boardList")
//	public String boardList(Model model) {
//		
//		model.addAttribute("list", boardService.getList());
//		return "board/boardList";
//	}
	
	@RequestMapping("boardList")
	public String boardList() {
		return "board/boardList";
	}
	
	@RequestMapping("boardListAjax")
	@ResponseBody
	public ArrayList<BoardDTO> boardListAjax() {
		return boardService.getList();
	}
	
	@RequestMapping("boardRegister")
	public String boardRegister() {
		return "board/boardRegister";
	}
	@RequestMapping("boardResult")
	public String boardResult() {
		return "board/boardResult";
	}
	
	@RequestMapping(value="boardForm", method=RequestMethod.POST)
	public String boardFrom(BoardDTO boardDTO) {
		
		boardService.regist(boardDTO);
		return "redirect:/board/boardResult";
	}
	
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam("bno") int num) {
		boardService.delete(num);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("boardContent")
	public String boardContent(@RequestParam("bno") int num, Model model) {
		model.addAttribute("boardDTO", boardService.getContent(num));
		return "board/boardContent";
	}
	
	@RequestMapping("boardEdit")
	public String boardEdit(@RequestParam("bno") int num, Model model) {
		model.addAttribute("boardDTO", boardService.getContent(num));
		return "board/boardEdit";
	}
	
	@RequestMapping("boardEditForm")
	public String boardEditForm(BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/boardContent?bno=" + boardDTO.getNum();
	}
}
