package com.simple.basic.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.MemberVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	// 화면 요청
	@RequestMapping("/res_ex01")
	public String resEx01() {
		
		// 결과 화면
		return "response/res_ex01";
	}
	
	// 1. model 전달자
	// 화면 요청
//	@RequestMapping("/res_ex02")
//	public String resEx02(Model model) {
//		
//		model.addAttribute("data", "홍길동");
//		model.addAttribute("now", new Date());
//		// 결과 화면
//		return "response/res_ex02";
//	}
	
	// 2. ModelAndView 전달자
	// 컨트롤러 보다는 다른 곳에서 주로 사용(ex filter 등)
	@RequestMapping("/res_ex02")
	public ModelAndView resEx02() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "홍길동");
		mv.addObject("now", new Date());
		mv.setViewName("response/res_ex02"); // 결과 화면 경로
		return mv;
	}
	
	// 3. @ModelAttribute = Request + Model 합성어
	@RequestMapping("/res_ex03")
	public String resEx03(
			// data 라는 이름의 값을 String data 로 넘겨줍니다.
			@ModelAttribute("info") String info
			) {
		System.out.println(info);
		return "response/res_ex03";
	}
	
	@RequestMapping("/res_ex04")
	public String resEx04( @ModelAttribute("info") MemberVO vo ) {
		System.out.println(vo.toString());
		return "response/res_ex04";
	}
	
	/////////////////////////////////////////////////////////////
	// Redirect ?
	// Spring 은 기본 이동방식이 forward 입니다.
	// redirect 는 다시 컨트롤러를 태우는 용도로 사용합니다.
	
	// 화면요청
	@RequestMapping("/login")
	public String loginView() {
		
		return "response/login";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String loginForm( 
			MemberVO vo, 
			RedirectAttributes ra) {
		
		// id 와 pw 가 동일하면 로그인 성공
		String id = vo.getId();
		String pw = vo.getPw();
		if(id.equals(pw)) { // 로그인 성공
			return "response/login_ok";
		} else { // 로그인 실패
			ra.addFlashAttribute("msg", "로그인 실패");
			// 리다이렉트를 보낼때, 1회성 휘발데이터로 데이터를 넘기는 방식을 제공해준다.
			return "redirect:/response/login";
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
