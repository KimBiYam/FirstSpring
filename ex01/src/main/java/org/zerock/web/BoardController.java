package org.zerock.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	BoardServiceImpl service;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);

		return "board/list";
	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String regsiter(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}

	@GetMapping({"/get","/modify"})
	public void get(Long bno, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);		
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify:" + board);
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
