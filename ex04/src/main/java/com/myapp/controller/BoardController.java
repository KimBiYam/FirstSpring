package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.domain.BoardVO;
import com.myapp.domain.Criteria;
import com.myapp.domain.PageDTO;
import com.myapp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service;

	@GetMapping("/register")
	public void getRegister() {

	}

	@PostMapping("/register")
	public String register(BoardVO board) {
		service.register(board);
		return "redirect:/board/list";
	}

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<BoardVO> list = service.getList(cri);
		model.addAttribute("list", list);

		int total = service.getTotal(cri);
		int rowNo = total - ((cri.getPageNum() - 1) * cri.getAmount());

		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("rowNo", rowNo);
	}

	@GetMapping("/get")
	public void get(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.get(bno);
		service.viewcnt(bno);
		model.addAttribute("board", board);
	}

	@GetMapping("/modify")
	public void modify(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		service.modify(board);

		return "redirect:/board/list" + cri.getListLink();
	}

	@PostMapping("/delete")
	public String modify(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		service.delete(bno);

		return "redirect:/board/list" + cri.getListLink();
	}

}
