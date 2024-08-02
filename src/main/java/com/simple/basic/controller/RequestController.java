package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemberVO;



@Controller
@RequestMapping("/request") // 이 컨트롤러 모든 요청경로 앞에 /request
public class RequestController {
	
	@RequestMapping("/req_ex01")
	public String reqEx01() {
		return "request/req_ex01"; // 화면 경로
	}
	// void 형은 들어온 요청경로로 나가는 경로를 지정합니다.(화면경로)
//	@RequestMapping("/req_ex01")
//	public void reqEx01() {
//	}
	
	//@RequestMapping(value = "/basic", method = RequestMethod.GET) // get만 허용
	//@RequestMapping(value = "/basic", method = RequestMethod.POST) // post만 허용
	@RequestMapping({"/basic","/basic2"}) // get, post 둘다 허용
	public String basic() {
		System.out.println("basic 요청 실행됨");
		return null;
	}
	
	//@GetMapping("/basic3") // RequestMapping + get만 허용
	@PostMapping("/basic3") // RequestMapping + post만 허용
	public String basic3() {
		System.out.println("basic3 요청 실행됨");
		return null;
	}
	
	///////////////////////////////////////////////////////////
	@RequestMapping("/req_ex02")
	public String reqEx02() {
		return "request/req_ex02";
	}
	
	// 기본 방식
	//@PostMapping("/param")
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param(HttpServletRequest request) {
//		
//		// 값 처리~~
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String[] check = request.getParameterValues("inter");
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(Arrays.toString(check));
//		
//		// 결과 화면
//		return "request/req_ex02_ok";
//	}
	
	
	// @RequestParam 방식 - 반드시 값을 화면에서 넘겨야 됨(필수)
	// 혹은 required 옵션을 false 로 주면 값이 없더라도 통과하게 된다.
	// defaultValue 옵션은 값이 없을 때 기본 값을 지정해 줄 수 있다.
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param(
//			@RequestParam("id") String id, 
//			@RequestParam("pw") String pw, 
//			@RequestParam(value = "inter", required = false, defaultValue = "none") ArrayList<String> inter
//			) {
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(inter);
//		
//		return "request/req_ex02_ok";
//	}
	
	// 커맨드객체를 통한 자동 맵핑
	// form 태그의 name 과 같은 이름의 멤버변수와 getter, setter 가 있어야한다!
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param( MemberVO vo ) {
		
		// 값 처리
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());
//		System.out.println(vo.getInter().toString());
		
		System.out.println(vo.toString());
		
		// 결과화면
		return "request/req_ex02_ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
