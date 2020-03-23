package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.vo.MyBoardVO;

@Service
public class MyBoardServiceImpl implements MyBoardService {
	@Autowired
	private MyBoardDAOImpl dao;

	@Override
	public void insert(MyBoardVO board) {
		// TODO Auto-generated method stub
		dao.dao_insert(board);
	}

	@Override
	public List<MyBoardVO> list(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return dao.dao_list(hm);
	}

	@Override
	public MyBoardVO view(int num) {
		// TODO Auto-generated method stub
		return dao.dao_view(num);
	}

	@Override
	public void update(MyBoardVO board) {
		// TODO Auto-generated method stub
		dao.dao_update(board);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		dao.dao_delete(num);
	}

//	��ȸ��
	public void hitcount(MyBoardVO board) {
		dao.dao_hitcount(board);
	}

//	�н����� üũ
	public String check(int num) {
		return dao.dao_check(num);
	}

// ī��Ʈ
	public int count(HashMap<String, Object> hm) {
		return dao.dao_count(hm);
	}

}
