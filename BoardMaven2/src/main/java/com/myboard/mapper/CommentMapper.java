package com.myboard.mapper;

import java.util.List;

import com.myboard.vo.CommentVO;

public interface CommentMapper {
//	��� �߰�
	public void commentInsert(CommentVO comment);
//	��� ����Ʈ
	public List<CommentVO> commentList(int bnum);
//	��� ����
	public void commentDelete(int num);
//	�Խñ� ������ ��� ���� 
	public void allCommentDelete(int bnum);
}
