package com.myboard.myboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.model.CommentServiceImpl;
import com.myboard.vo.CommentVO;

@Controller
public class CommentController {
	@Autowired
	CommentServiceImpl service;
	
//	��� �߰�
	@GetMapping("commentInsert")
	public String commentInsert(CommentVO comment) {
		service.commentInsert(comment);
		return "redirect:commentList?bnum="+comment.getBnum();
	}
	
//	��� ����Ʈ
	@GetMapping("commentList")
	@ResponseBody
	public List<CommentVO> commentList(int bnum){
		return service.commentList(bnum);
	}
//	��� ����
	@GetMapping("commentDelete")
	public String commentDelete(int num,int bnum) {
		service.commentDelete(num);
		return "redirect:commentList?bnum="+bnum;
	}

}
