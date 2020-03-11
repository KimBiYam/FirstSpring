package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemServiceImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemServiceImpl mService;

	// 함수가 void 이면 매핑이름.jsp를 알아서 찾아감
	@RequestMapping("member_insert.mb")
	public void insert() {

	}

	// 추가
	@RequestMapping(value = "member_insert.mb", method = RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		return "redirect:member_list.mb";
	}

	// 리스트
	@RequestMapping("member_list.mb")
	public String list(Model model) {
		List<MemberVO> memlist = mService.list();
		model.addAttribute("userlist", memlist);
		return "list";
	}

	// 상세보기
	@RequestMapping("member_detail.mb")
	public String detail(Model model, String id) {
		MemberVO mUser = mService.view(id);
		model.addAttribute("user", mUser);		
		return "detail";
	}

	// 수정폼
	@RequestMapping("member_update.mb")
	public String update(Model model, String id) {
		MemberVO mUser = mService.view(id);
		model.addAttribute("user", mUser);
		return "member_form_update";
	}

	// 수정
	@RequestMapping(value = "member_update.mb", method = RequestMethod.POST)
	public String update(Model model, MemberVO member) {
		mService.update(member);
		return "redirect:member_list.mb";
	}
	
	//삭제
	@RequestMapping("member_delete.mb")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:member_list.mb";
	}

}
