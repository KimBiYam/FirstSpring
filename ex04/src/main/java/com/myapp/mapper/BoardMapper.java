package com.myapp.mapper;

import java.util.List;

import com.myapp.domain.BoardVO;
import com.myapp.domain.Criteria;

public interface BoardMapper {
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
	public List<BoardVO> getListWithPaging(Criteria cri);
	public int getTotalCount(Criteria cri);
	public void viewcnt(Long bno);
}
