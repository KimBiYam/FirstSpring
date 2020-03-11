package com.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.annotation.Resource;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberServiceImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	@Resource(name = "service")
	private MemberServiceImpl service;

	// 추가폼
	@RequestMapping("member_insert.go")
	public String FormInsert() {
		return "memberInsert";
	}

	// 추가
	@RequestMapping(value = "member_insert.go", method = RequestMethod.POST)
	public String Insert(MemberVO user) {
		service.insert(user);
		return "redirect:member_list.go";
	}

	// 리스트
	// ModelAndView 객체를 생성하지않고
	// Model 객체를 이용해서 값을 저장하고 String을 반환해줌
	@RequestMapping("member_list.go")
	public String List(Model model) {
		List<MemberVO> userlist = service.list();
		model.addAttribute("userlist", userlist);
		return "list";
	}

	// 상세보기
	@RequestMapping("member_detail.go")
	public String View(Model model, String id) {
		MemberVO user = service.detail(id);
		model.addAttribute("user", user);
		return "detail";
	}

	// 수정폼
	@RequestMapping("member_update.go")
	public String UpdateForm(Model model, String id) {
		MemberVO user = service.detail(id);
		model.addAttribute("user", user);
		return "member_form_update";
	}

	// 수정
	@RequestMapping(value = "member_update.go", method = RequestMethod.POST)
	public String Update(MemberVO user) {
		service.update(user);		
		return "redirect:member_list.go";
	}

	// 삭제
	@RequestMapping("member_delete.go")
	public String Delete(String id) {
		service.delete(id);
		return "redirect:member_list.go";
	}

}
