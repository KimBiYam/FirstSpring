package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.mapper.CommentMapper;
import com.myboard.mapper.MyBoardMapper;
import com.myboard.vo.MyBoardVO;

@Repository
public class MyBoardDAOImpl implements MyBoardDAO {
	@Autowired
	private MyBoardMapper bMapper;
	@Autowired
	private CommentMapper cMapper;

	@Override
	public void dao_insert(MyBoardVO board) {
		// TODO Auto-generated method stub
		bMapper.insert(board);
	}

	@Override
	public List<MyBoardVO> dao_list(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return bMapper.list(hm);
	}

	@Override
	public MyBoardVO dao_view(int num) {
		// TODO Auto-generated method stub
		return bMapper.view(num);
	}

	@Override
	public void dao_update(MyBoardVO board) {
		// TODO Auto-generated method stub
		bMapper.update(board);
	}

	@Override
	public void dao_delete(int num) {
		// TODO Auto-generated method stub
		bMapper.delete(num);
		cMapper.allCommentDelete(num);
	}

//	조회수
	public void dao_hitcount(MyBoardVO board) {
		bMapper.hitcount(board);
	}
	
//	패스워드 체크
	public String dao_check(int num) {
		return bMapper.check(num);
	}
	
//	카운트
	public int dao_count(HashMap<String, Object> hm) {
		return bMapper.count(hm);
	}



}
