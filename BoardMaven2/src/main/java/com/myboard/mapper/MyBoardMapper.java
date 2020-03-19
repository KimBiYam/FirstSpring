package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import com.myboard.vo.CommentVO;
import com.myboard.vo.MyBoardVO;

public interface MyBoardMapper {
	//�߰�
	//����Ʈ
	//�󼼺���
	//����
	//����
	public void insert(MyBoardVO board);
	public List<MyBoardVO> list(HashMap<String, Object> hm);
	public MyBoardVO view(int num);
	public void update(MyBoardVO board);
	public void delete(int num);
//	��ȸ��
	public void hitcount(MyBoardVO board);
//	�н����� üũ
	public String check(int num);
//	ī��Ʈ
	public int count(HashMap<String, Object> hm);
//	��� �߰�
	public void commentInsert(CommentVO comment);
//	��� ����Ʈ
	public List<CommentVO> commentList(int bnum);
//	��� ����
	public void commentDelete(int num);
}
