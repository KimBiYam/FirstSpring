package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.vo.MyBoardVO;

public interface MyBoardService {
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
}
