package com.myboard.model;

import java.util.List;

import com.myboard.vo.CommentVO;

public interface CommentDAO {
	// ¥Ò±€ √ﬂ∞°
	public void dao_commentInsert(CommentVO comment);
	//	¥Ò±€ ∏ÆΩ∫∆Æ
	public List<CommentVO> dao_commentList(int bnum);
	//	¥Ò±€ ªË¡¶
	public void dao_commentDelete(int num) ;
}
