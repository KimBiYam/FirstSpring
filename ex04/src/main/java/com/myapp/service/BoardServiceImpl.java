package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.domain.BoardVO;
import com.myapp.domain.Criteria;
import com.myapp.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService{
	@Setter(onMethod_= @Autowired)
	BoardMapper boardMapper;
	

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.register(board);		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.get(bno);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return boardMapper.list();
	}

	@Override
	public void modify(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.modify(board);
	}

	@Override
	public void delete(Long bno) {
		// TODO Auto-generated method stub
		boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public void viewcnt(Long bno) {
		// TODO Auto-generated method stub
		boardMapper.viewcnt(bno);
	}
	
	

}
