package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.vo.MyBoardVO;

public interface MyBoardDAO {
	//추가
	//리스트
	//상세보기
	//수정
	//삭제
	public void dao_insert(MyBoardVO board);
	public List<MyBoardVO> dao_list(HashMap<String, Object> hm);
	public MyBoardVO dao_view(int num);
	public void dao_update(MyBoardVO board);
	public void dao_delete(int num);
}
