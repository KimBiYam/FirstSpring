package org.zerock.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardListVO;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardServiceImpl;
import org.zerock.util.PageUtil;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	BoardServiceImpl service;
	@Autowired
	private PageUtil page;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@GetMapping("/list")
	@ResponseBody
	public BoardListVO list(Model model, String field, String word, String pageNum) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		if (field == null)
			field = "";
		if (word == null)
			word = "";
		hm.put("field", field);
		hm.put("word", word);
		int count = service.count(hm);

		int pageSize = 5;
		if (pageNum == null)
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		if (endRow > count)
			endRow = count;

		hm.put("startRow", startRow);
		hm.put("endRow", endRow);

		List<BoardVO> list = service.getList(hm);
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);

		int rowNo = count - ((currentPage - 1) * pageSize);

//		model.addAttribute("list", list);

		BoardListVO listVO = new BoardListVO(list, pageHtml, rowNo);

		return listVO;

	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String regsiter(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/";
	}

	@GetMapping({ "/get", "/modify" })
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
		return "redirect:/";
	}

	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";
	}

}
