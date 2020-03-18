package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.vo.MyBoardVO;

public interface MyBoardService {
	//추가
	//리스트
	//상세보기
	//수정
	//삭제
	public void insert(MyBoardVO board);
	public List<MyBoardVO> list(HashMap<String, Object> hm);
	public MyBoardVO view(int num);
	public void update(MyBoardVO board);
	public void delete(int num);
}
