package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 선언
@Controller
public class TestController {
	// 매핑
	@RequestMapping("test.go")
	// 컨트롤러에서 String은 view(jsp)를 의미함
	public String test() {
		return "result"; // WEB-INF/jsp/result.jsp
	}

}
