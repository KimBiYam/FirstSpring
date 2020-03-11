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

	// �Լ��� void �̸� �����̸�.jsp�� �˾Ƽ� ã�ư�
	@RequestMapping("member_insert.mb")
	public void insert() {

	}

	// �߰�
	@RequestMapping(value = "member_insert.mb", method = RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		return "redirect:member_list.mb";
	}

	// ����Ʈ
	@RequestMapping("member_list.mb")
	public String list(Model model) {
		List<MemberVO> memlist = mService.list();
		model.addAttribute("userlist", memlist);
		return "list";
	}

	// �󼼺���
	@RequestMapping("member_detail.mb")
	public String detail(Model model, String id) {
		MemberVO mUser = mService.view(id);
		model.addAttribute("user", mUser);		
		return "detail";
	}

	// ������
	@RequestMapping("member_update.mb")
	public String update(Model model, String id) {
		MemberVO mUser = mService.view(id);
		model.addAttribute("user", mUser);
		return "member_form_update";
	}

	// ����
	@RequestMapping(value = "member_update.mb", method = RequestMethod.POST)
	public String update(Model model, MemberVO member) {
		mService.update(member);
		return "redirect:member_list.mb";
	}
	
	//����
	@RequestMapping("member_delete.mb")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:member_list.mb";
	}

}
