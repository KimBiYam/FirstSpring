package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import com.myboard.vo.CommentVO;
import com.myboard.vo.MyBoardVO;

public interface MyBoardMapper {
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
//	조회수
	public void hitcount(MyBoardVO board);
//	패스워드 체크
	public String check(int num);
//	카운트
	public int count(HashMap<String, Object> hm);
//	댓글 추가
	public void commentInsert(CommentVO comment);
//	댓글 리스트
	public List<CommentVO> commentList(int bnum);
//	댓글 삭제
	public void commentDelete(int num);
}
