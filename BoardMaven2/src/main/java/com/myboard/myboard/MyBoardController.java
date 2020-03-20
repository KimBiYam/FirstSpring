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
import com.myboard.vo.BoardListVO;
import com.myboard.vo.CommentVO;
import com.myboard.vo.MyBoardVO;

@Controller
public class MyBoardController {
	@Autowired
	private MyBoardServiceImpl service;
	@Autowired
	private PageUtil page;

//	추가폼
	@GetMapping("boardInsert")
	public String insert() {
		return "boardInsert";
	}

//	추가
	@PostMapping("boardInsert")
	public String insert(MyBoardVO board) {
		service.insert(board);
		return "boardList";
	}

//	리스트 폼
	@GetMapping("goList")
	public String list() {
		return "boardList";
	}

//	리스트
	@GetMapping(value = "boardList")
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

		List<MyBoardVO> list = service.list(hm);
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);

		int rowNo = count - ((currentPage - 1) * pageSize);
//		List<Object> obj = new ArrayList<Object>();
//		obj.add(count);
//		obj.add(list);
//		obj.add(pageHtml);
//		obj.add(rowNo);
		BoardListVO listVO = new BoardListVO(count, list, pageHtml, rowNo);

		return listVO;
	}

//	상세보기
	@GetMapping("boardView")
	public String view(Model model, int num) {
		MyBoardVO board = service.view(num);
		service.hitcount(board);
		board.setHitcount(board.getHitcount() + 1);
		model.addAttribute("board", board);
		return "boardView";
	}

//	수정폼
	@GetMapping("boardUpdate")
	public String update(Model model, int num) {
		MyBoardVO board = service.view(num);
		model.addAttribute("board", board);
		return "boardUpdate";
	}

//	수정
	@PostMapping("boardUpdate")
	public String update(MyBoardVO board) {
		service.update(board);
		return "boardList";
	}

//	삭제팝업
	@GetMapping("deletePopup")
	public String delete(Model model, int num) {
		model.addAttribute("num", num);
		return "boardDelete";
	}

//	삭제
	@GetMapping("boardDelete")
	public String delete(int num) {
		service.delete(num);
		return "boardList";
	}

//	패스워드 체크
	@GetMapping(value = "passwordCheck", produces = "application/text; charset=utf8")
	@ResponseBody
	public String passwordCheck(int num, String password) {
		String pwd = service.check(num);
		String str = "";
		str = (pwd.equals(password)) ? "yes" : "no";
		return str;
	}
	
//	댓글 추가
	@GetMapping("commentInsert")
	public String commentInsert(CommentVO comment) {
		service.commentInsert(comment);
		return "redirect:commentList?bnum="+comment.getBnum();
	}
	
//	댓글 리스트
	@GetMapping("commentList")
	@ResponseBody
	public List<CommentVO> commentList(int bnum){
		return service.commentList(bnum);
	}
//	댓글 삭제
	@GetMapping("commentDelete")
	public String commentDelete(int num,int bnum) {
		service.commentDelete(num);
		return "redirect:commentList?bnum="+bnum;
	}
	
	
}
