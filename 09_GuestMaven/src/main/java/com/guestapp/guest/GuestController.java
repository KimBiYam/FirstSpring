package com.guestapp.guest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.guestapp.model.GuestServiceImpl;
import com.guestapp.util.PageUtil;
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
	public String insert(GuestVO guest) {
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
	public String list(Model model, String field, String word, String pageNum) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
//
//		String page = pageNum == null ? "1" : pageNum;			
//		int currentPage = Integer.parseInt(page);
//		int pageSize = 5;
//		int startRow = (currentPage - 1) * pageSize + 1;
//		int endRow = currentPage * pageSize;
//
//		int count = service.count();
//		int totpage = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
//		int pageblock = 5;
//		int startpage = ((currentPage - 1) / pageblock) * pageblock + 1;
//		int endpage = startpage + pageblock - 1;
//		if (endpage > totpage)
//			endpage = totpage;
//
//		PageUtil pu = new PageUtil();
//		pu.setStartpage(startpage);
//		pu.setCurrentPage(currentPage);
//		pu.setEndpage(endpage);
//		pu.setPageblock(pageblock);
//		pu.setTotpage(totpage);
//		pu.setField(field);
//
//		model.addAttribute("pu", pu);
//		model.addAttribute("count", count);
//
//		hm.put("startRow", Integer.toString(startRow));
//		hm.put("endRow", Integer.toString(endRow));
		
		List<GuestVO> list = service.list(hm);
//		int rowNo = count - ((currentPage - 1) * pageSize);
//		model.addAttribute("rowNo", rowNo);
		model.addAttribute("guestlist", list);

		return "list";
	}

	// 상세보기
	@GetMapping("gView")
	public String view(Model model, int num) {
		GuestVO guest = service.findById(num);
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
