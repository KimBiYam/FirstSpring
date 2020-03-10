package com.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAOImpl dao;

	// �߰���
	@RequestMapping("member_insert.go")
	public String FormInsert() {
		return "memberInsert";
	}

	// �߰�
	@RequestMapping(value = "member_insert.go", method = RequestMethod.POST)
	public String Insert(MemberVO user) {
		dao.insert(user);
		return "redirect:member_list.go";
	}

	// ����Ʈ
	// ModelAndView ��ü�� ���������ʰ�
	// Model ��ü�� �̿��ؼ� ���� �����ϰ� String�� ��ȯ����
	@RequestMapping("member_list.go")
	public String List(Model model) {
		List<MemberVO> userlist = dao.getMemberList();
		model.addAttribute("userlist", userlist);
		return "list";
	}

	// �󼼺���
	@RequestMapping("member_detail.go")
	public String View(Model model, String id) {
		MemberVO user = dao.findById(id);
		model.addAttribute("user", user);
		return "detail";
	}

	// ������
	@RequestMapping("member_update.go")
	public String UpdateForm(Model model, String id) {
		MemberVO user = dao.findById(id);
		model.addAttribute("user", user);
		return "member_form_update";
	}

	// ����
	@RequestMapping(value = "member_update.go", method = RequestMethod.POST)
	public String Update(MemberVO user) {
		dao.update(user);		
		return "redirect:member_list.go";
	}

	// ����
	@RequestMapping("member_delete.go")
	public String Delete(String id) {
		dao.delete(id);
		return "redirect:member_list.go";
	}

}
