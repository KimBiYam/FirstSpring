package org.zerock.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;
import org.zerock.service.MemberServiceImpl;

@SessionAttributes("member")
@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private MemberService service;

//	ȸ�� ���� ��
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

//	ȸ�� ����
	@PostMapping("/register")
	public String register(MemberVO member) {
		service.register(member);
		return "redirect:/";
	}

//	���θ��ּ� API �˾�
	@RequestMapping("/popup")
	public String popup() {
		return "/member/popup/jusoPopup";
	}

//	���̵� �ߺ� üũ
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

//	�α��� ��
	@GetMapping("/loginForm")
	public String login() {
		return "member/login";
	}

//	�α���
	@GetMapping("/login")
	public String login(Model model, String id) {
		MemberVO member = service.get(id);
		model.addAttribute("member", member);
		return "redirect:/";
	}
//	�α׾ƿ�
	@GetMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
	
//	�������� ��
	@GetMapping("/modify")
	public void modify() {
		
	}
//	���� ����
	@PostMapping("/modify")
	public String modfiy(SessionStatus session, MemberVO member) {
		service.modify(member);
		session.setComplete();		
		return "redirect:/member/login?id="+member.getId();		
	}
//	ȸ�� Ż��
	@GetMapping("/delete")
	public String delete(String id) {
		MemberVO member = service.get(id);
		service.delete(member);
		return "redirect:/member/logout";		
	}
	
	
//	�α��� üũ
	@GetMapping("/loginCheck")
	@ResponseBody	
	public String login(String id, String password) {
		String chkId = service.idcheck(id);

		if (chkId == null) {
			return "no";
		} else {
			MemberVO member = service.get(id);
			if (member.getPassword().equals(password)) {
				return "success";
			} else {
				return "fail";
			}
		}

	}

}