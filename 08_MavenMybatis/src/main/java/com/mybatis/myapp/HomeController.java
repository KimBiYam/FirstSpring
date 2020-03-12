package com.mybatis.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.model.MemberServiceImpl;
import com.mybatis.model.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 추가 폼
	@RequestMapping(value = "mInsert", method = RequestMethod.GET)
	public String insert() {
		return "member_insert";
	}

	// 추가
	@RequestMapping(value = "mInsert", method = RequestMethod.POST)
	public String insert(MemberVO member) {
		service.insert(member);
		return "redirect:mList";
	}

	// 리스트
	@RequestMapping("mList")
	public String list(Model model) {
		List<MemberVO> list = service.list();
		model.addAttribute("userlist", list);
		return "list";
	}

	// 상세보기
	@RequestMapping("mView")
	public String view(Model model, String id) {
		MemberVO member = service.view(id);
		model.addAttribute("user", member);
		return "detail";
	}

	// 수정 폼
	@RequestMapping(value = "mUpdate", method = RequestMethod.GET)
	public String update(Model model, String id) {
		MemberVO member = service.view(id);
		model.addAttribute("user", member);
		return "member_form_update";
	}

	// 수정
	@RequestMapping(value = "mUpdate", method = RequestMethod.POST)
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:mList";
	}

	// 삭제
	@RequestMapping("mDelete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:mList";
	}

}
