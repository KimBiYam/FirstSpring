package com.myapp.service;

import java.util.List;

import com.myapp.domain.BoardVO;

public interface BoardService {
	//작성
	//조회
	//리스트
	//수정
	//삭제
	
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public List<BoardVO> list();
	public void modify(BoardVO board);
	public void delete(Long bno);

}
