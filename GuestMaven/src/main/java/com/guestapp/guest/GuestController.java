package com.guestapp.guest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestapp.model.GuestServiceImpl;
import com.guestapp.vo.GuestVO;

@Controller
public class GuestController {
	@Autowired
	GuestServiceImpl service;

	// GetMapping, PostMapping�� �̿��ϸ� method�� ���� ���������ʾƵ� ��
	// �߰� ��
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}

	// �߰�
	@PostMapping("gInsert")
	//@ModelAttribute : �𵨿� �ش� �̸����� ��ü�� �����
	public String insert(@ModelAttribute("guest") GuestVO guest) {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
			guest.setIpaddr(local.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.insert(guest);
		return "redirect:gList";
	}

	// ����Ʈ
	@GetMapping("gList")
	public String list(Model model, String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestVO> list = service.list(hm);
		model.addAttribute("guestlist", list);
		return "list";
	}

	// �󼼺���
	@GetMapping("gView")
	//@RequestParam("num") int no : num���� �Ѿ���� ���� no�� �ްڴٴ� �� 
	public String view(Model model, @RequestParam("num") int no) {
		GuestVO guest = service.findById(no);
		model.addAttribute("guest", guest);
		return "view";
	}

	// ���� ��
	@GetMapping("gUpdate")
	public String update(Model model, int num) {
		GuestVO guest = service.findById(num);
		model.addAttribute("guest", guest);
		return "update";
	}

	// ����
	@PostMapping("gUpdate")
	public String update(GuestVO guest) {
		service.update(guest);
		return "redirect:gList";
	}

	// ����
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:gList";
	}

}
