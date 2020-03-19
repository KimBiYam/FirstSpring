package com.myboard.myboard;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.model.MyBoardServiceImpl;
import com.myboard.util.PageUtil;
import com.myboard.vo.MyBoardVO;

@Controller
public class MyBoardController {
	@Autowired
	private MyBoardServiceImpl service;
	@Autowired
	private PageUtil page;

//	�߰���
	@GetMapping("boardInsert")
	public String insert() {
		return "boardInsert";
	}

//	�߰�
	@PostMapping("boardInsert")
	public String insert(MyBoardVO board) {
		service.insert(board);
		return "boardList";
	}

//	����Ʈ ��
	@GetMapping("boardList")
	public String list() {
		return "boardList";
	}

//	����Ʈ
	@PostMapping("boardList")
	public String list(Model model, String field, String word, String pageNum) {
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

		List<MyBoardVO> list = service.list(hm);
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);

		int rowNo = count - ((currentPage - 1) * pageSize);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("rowNo", rowNo);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		return "list";
	}

//	�󼼺���
	@GetMapping("boardView")
	public String view(Model model, int num) {
		MyBoardVO board = service.view(num);
		service.hitcount(board);
		board.setHitcount(board.getHitcount() + 1);
		model.addAttribute("board", board);
		return "boardView";
	}

//	������
	@GetMapping("boardUpdate")
	public String update(Model model, int num) {
		MyBoardVO board = service.view(num);
		model.addAttribute("board", board);
		return "boardUpdate";
	}

//	����
	@PostMapping("boardUpdate")
	public String update(MyBoardVO board) {
		service.update(board);
		return "boardList";
	}

//	�����˾�
	@GetMapping("deletePopup")
	public String delete(Model model, int num) {
		model.addAttribute("num", num);
		return "boardDelete";
	}

//	����
	@GetMapping("boardDelete")
	public String delete(int num) {
		service.delete(num);
		return "boardList";
	}

//	�н����� üũ
	@GetMapping(value = "passwordCheck", produces = "application/text; charset=utf8")
	@ResponseBody
	public String passwordCheck(int num, String password) {
		String pwd = service.check(num);
		String str = "";
		str = (pwd.equals(password)) ? "yes" : "no";
		return str;
	}
}