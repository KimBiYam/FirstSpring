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

	// �߰���
	@RequestMapping("member_insert.go")
	public String FormInsert() {
		return "memberInsert";
	}

	// �߰�
	@RequestMapping(value = "member_insert.go", method = RequestMethod.POST)
	public String Insert(MemberVO user) {
		service.insert(user);
		return "redirect:member_list.go";
	}

	// ����Ʈ
	// ModelAndView ��ü�� ���������ʰ�
	// Model ��ü�� �̿��ؼ� ���� �����ϰ� String�� ��ȯ����
	@RequestMapping("member_list.go")
	public String List(Model model) {
		List<MemberVO> userlist = service.list();
		model.addAttribute("userlist", userlist);
		return "list";
	}

	// �󼼺���
	@RequestMapping("member_detail.go")
	public String View(Model model, String id) {
		MemberVO user = service.detail(id);
		model.addAttribute("user", user);
		return "detail";
	}

	// ������
	@RequestMapping("member_update.go")
	public String UpdateForm(Model model, String id) {
		MemberVO user = service.detail(id);
		model.addAttribute("user", user);
		return "member_form_update";
	}

	// ����
	@RequestMapping(value = "member_update.go", method = RequestMethod.POST)
	public String Update(MemberVO user) {
		service.update(user);		
		return "redirect:member_list.go";
	}

	// ����
	@RequestMapping("member_delete.go")
	public String Delete(String id) {
		service.delete(id);
		return "redirect:member_list.go";
	}

}
