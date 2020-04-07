package com.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.domain.AuthVO;
import com.myapp.domain.MemberVO;
import com.myapp.service.MemberService;

@RequestMapping("/member/")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/popup", method = { RequestMethod.POST, RequestMethod.GET })
	public String popup() {
		return "/jusoPopup";
	}
	
	@PostMapping("/register")
	public String register(MemberVO member, AuthVO auth) {
		service.register(member, auth);		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return "redirect:/";
	}
	
//	아이디 중복 체크
	@GetMapping("/idcheck")
	@ResponseBody
	public String idcheck(String id) {
		String chkId = service.idcheck(id);
//		System.out.println(chkId);

		if (chkId == null) {
//			System.out.println("yes");
			return "yes";
		} else {
//			System.out.println("no");
			return "no";
		}

	}
	

}
