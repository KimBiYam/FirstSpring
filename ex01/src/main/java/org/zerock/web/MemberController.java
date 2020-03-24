package org.zerock.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberServiceImpl service;

	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

	@PostMapping("/register")
	public String register(MemberVO member) {
		service.register(member);
		return "redirect:/";
	}
	@GetMapping("/popup")
	public String popup() {
		return "/member/popup/jusoPopup";
	}
	

}

