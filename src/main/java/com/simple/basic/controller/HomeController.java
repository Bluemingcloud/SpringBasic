package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컴포넌트
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

}
