package com.guestapp.guest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	// @ModelAttribute : �𵨿� �ش� �̸����� ��ü�� �����
	public String insert(@ModelAttribute("guest") GuestVO guest) {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
			guest.setIpaddr(local.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
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
		int count = service.count(hm);
		model.addAttribute("count", count);
		model.addAttribute("guestlist", list);
		return "list";
	}

	// �󼼺���
	// ResponseBody : return���� view�� �ƴ϶� ���ΰ�� ���
	// ���������� json�� �Ľ��ϴ°�쿡�� produces = "application/text; charset=utf8"�� �߰��Ͽ� �ѱ� ó��
	@GetMapping(value = "gView", produces = "application/text; charset=utf8")
	@ResponseBody
	// @RequestParam("num") int no : num���� �Ѿ���� ���� no�� �ްڴٴ� ��
	public String view(@RequestParam("num") int no) {
		GuestVO guest = service.findById(no);
		JSONObject obj = new JSONObject();
		obj.put("name", guest.getName());
		obj.put("content", guest.getContent());
		obj.put("created", guest.getCreated());
		obj.put("grade", guest.getGrade());
		obj.put("ipaddr", guest.getIpaddr());

		return obj.toString();
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

	// �α��� ��
	@GetMapping("login")
	public void login() {
	}

	// �α���
	@PostMapping("login")
	// HttpSession ��ü�� �ٷ� ���ڰ����� �޾ƿ͵� ��	
	public String login(String id, String pwd, HttpSession session, Model model) {
//		HttpSession session = req.getSession();
		if (id.equals("admin")&&pwd.equals("1234")) {
			session.setAttribute("login", true);
			return "insert";
		}else {
			model.addAttribute("errMsg","���̵� / �н����� ����");
			return "login";
		}
	}

	// �α׾ƿ�
	@GetMapping("logout")
	public String logout(HttpSession session) {
//		HttpSession session = req.getSession();
		session.invalidate();
		return "insert";
	}

}
