package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.ScoreService;
//import com.simple.basic.service.score.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	// 컨트롤러 내에서 항상 사용할 서비스 이므로 멤버변수로 선언
	//ScoreService service = new ScoreServiceImpl(); // 호출시 항상 새로운 객체가 생성됨. Spring 방식이 아님!
	
	// serviceImpl 클래스를 bean 으로 등록
	@Autowired
	@Qualifier("scoreService") // 서비스 클래스의 이름(어노테이션 안의 값) 으로 지정
	ScoreService scoreService;
	
	// 목록
//	@RequestMapping("scoreList")
//	public String scoreList(Model model) {
//		// select 해서 model에 담아서 화면으로...
//		model.addAttribute("list", scoreService.getList());
//		return "service/scoreList";
//	}
	@RequestMapping("scoreList")
	public String scoreList() {
		return "service/scoreList";
	}
	
	@RequestMapping("getScoreList")
	@ResponseBody
	public ArrayList<ScoreVO> getScoreList() {
		// select 해서 model에 담아서 화면으로...
		ArrayList<ScoreVO> list = scoreService.getList();
		return list; 
	}
	
	// 등록 화면
	@RequestMapping("scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	// 결과
	@RequestMapping("scoreResult")
	public String scoreResult() {
		return "service/scoreResult";
	}
	
	// 등록 요청시
//	@RequestMapping(value = "scoreForm", method = RequestMethod.POST)
//	public String scoreForm(
//			@RequestParam("name") String name,
//			@RequestParam("kor") int kor,
//			@RequestParam("math") int math,
//			@RequestParam("eng") int eng
//			) {
//		
//		
//		return "service/scoreResult"; // 결과 화면
//	}
	
	@RequestMapping(value = "scoreForm", method = RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		scoreService.regist(vo);
		return "service/scoreResult"; // 결과 화면
	}
	
	// 삭제요청
	@RequestMapping("/deleteScore")
	public String deleteScore(@RequestParam("sno") int sno) {
		scoreService.delete(sno);
		return "redirect:/service/scoreList";
	}
	
}
