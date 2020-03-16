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

	// GetMapping, PostMapping을 이용하면 method를 따로 적어주지않아도 됨
	// 추가 폼
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}

	// 추가
	@PostMapping("gInsert")
	//@ModelAttribute : 모델에 해당 이름으로 객체를 담아줌
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

	// 리스트
	@GetMapping("gList")
	public String list(Model model, String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestVO> list = service.list(hm);
		model.addAttribute("guestlist", list);
		return "list";
	}

	// 상세보기
	@GetMapping("gView")
	//@RequestParam("num") int no : num으로 넘어오는 값을 no로 받겠다는 뜻 
	public String view(Model model, @RequestParam("num") int no) {
		GuestVO guest = service.findById(no);
		model.addAttribute("guest", guest);
		return "view";
	}

	// 수정 폼
	@GetMapping("gUpdate")
	public String update(Model model, int num) {
		GuestVO guest = service.findById(num);
		model.addAttribute("guest", guest);
		return "update";
	}

	// 수정
	@PostMapping("gUpdate")
	public String update(GuestVO guest) {
		service.update(guest);
		return "redirect:gList";
	}

	// 삭제
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:gList";
	}

}
