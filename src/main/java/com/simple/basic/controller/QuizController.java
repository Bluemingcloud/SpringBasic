package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.Quiz02VO;
import com.simple.basic.command.QuizUserVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("info") QuizUserVO vo, RedirectAttributes ra) {
		System.out.println(vo.toString()); // 커맨드객체로 받을때는 값이 없을때 "" 공백 이 담긴채 넘어온다.
		if(vo.getId() == null || vo.getId() == "") {
			ra.addFlashAttribute("msg", "아이디를 입력하세요.");
			return "redirect:/quiz/quiz01";
			
		}else if(vo.getPw() == null || vo.getPw() == "") {
			ra.addFlashAttribute("msg", "비밀번호를 입력하세요.");
			return "redirect:/quiz/quiz01";
			
		}else if(vo.getName() == null || vo.getName() == "") {
			ra.addFlashAttribute("msg", "이름을 입력하세요.");
			return "redirect:/quiz/quiz01";
			
		}else {
			return "quiz/quiz01_ok";
		}
		
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping(value = "/celebrate", method = RequestMethod.POST)
	public String celebrate(Quiz02VO vo, RedirectAttributes ra) {
		
		ra.addFlashAttribute("data", vo);
		return "redirect:/quiz/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "quiz/result";
	}
}
