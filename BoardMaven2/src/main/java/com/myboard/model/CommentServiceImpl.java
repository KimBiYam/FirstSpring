package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAOImpl dao;
	
	// ��� �߰�
		public void commentInsert(CommentVO comment) {
			dao.dao_commentInsert(comment);
		}
//		��� ����Ʈ
		public List<CommentVO> commentList(int bnum){
			return dao.dao_commentList(bnum);
		}
//		��� ����
		public void commentDelete(int num) {
			dao.dao_commentDelete(num);
		}

}
