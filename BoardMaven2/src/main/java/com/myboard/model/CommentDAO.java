package com.myboard.model;

import java.util.List;

import com.myboard.vo.CommentVO;

public interface CommentDAO {
	// ��� �߰�
	public void dao_commentInsert(CommentVO comment);
	//	��� ����Ʈ
	public List<CommentVO> dao_commentList(int bnum);
	//	��� ����
	public void dao_commentDelete(int num) ;
}
