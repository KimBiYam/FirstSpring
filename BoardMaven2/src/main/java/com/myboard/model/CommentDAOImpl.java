package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.mapper.CommentMapper;
import com.myboard.vo.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	CommentMapper cMapper;
	
	// ¥Ò±€ √ﬂ∞°
		public void dao_commentInsert(CommentVO comment) {
			cMapper.commentInsert(comment);
		}
//		¥Ò±€ ∏ÆΩ∫∆Æ
		public List<CommentVO> dao_commentList(int bnum){
			return cMapper.commentList(bnum);
		}
//		¥Ò±€ ªË¡¶
		public void dao_commentDelete(int num) {
			cMapper.commentDelete(num);
		}

}
