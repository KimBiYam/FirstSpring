package com.myapp.service;

import java.util.List;

import com.myapp.domain.BoardVO;
import com.myapp.domain.Criteria;

public interface BoardService {
	//�ۼ�
	//��ȸ
	//����Ʈ
	//����
	//����
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public List<BoardVO> list();
	public void modify(BoardVO board);
	public void delete(Long bno);
	public List<BoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public void viewcnt(Long bno);

}
