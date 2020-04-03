package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.domain.BoardVO;
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
		return "redirect:/";
	}

	@GetMapping("/list")
	public void list(Model model) {
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
	}

	@GetMapping("/get")
	public void get(Long bno, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
	}

}
