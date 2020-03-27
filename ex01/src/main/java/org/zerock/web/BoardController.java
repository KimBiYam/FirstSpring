package org.zerock.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;
import org.zerock.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService service;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		int total = service.getTotal(cri);
		List<BoardVO> list = service.getList(cri);
		int rowNo = total - ((cri.getPageNum() - 1) * 10);
		model.addAttribute("list", list);
		model.addAttribute("rowNo", rowNo);
		model.addAttribute("total", total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String regsiter(BoardVO board, RedirectAttributes rttr) {

		if (service.register(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@GetMapping({ "/get", "/modify" })
	public void get(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list" + cri.getListLink();
	}

	@PostMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list" + cri.getListLink();
	}

}
