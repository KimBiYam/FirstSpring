package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ��Ʈ�ѷ� ����
@Controller
public class TestController {
	// ����
	@RequestMapping("test.go")
	// ��Ʈ�ѷ����� String�� view(jsp)�� �ǹ���
	public String test() {
		return "result"; // WEB-INF/jsp/result.jsp
	}

}
