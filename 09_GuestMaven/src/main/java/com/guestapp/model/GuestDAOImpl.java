package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guestapp.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void dao_insert(String mid, GuestVO guest) {
		// TODO Auto-generated method stub
		sqlSession.insert(mid, guest);
	}

	@Override
	public void dao_update(String mid, GuestVO guest) {
		// TODO Auto-generated method stub
		sqlSession.update(mid, guest);
	}

	@Override
	public void dao_delete(String mid, int num) {
		// TODO Auto-generated method stub
		sqlSession.delete(mid, num);
	}

	@Override
	public List<GuestVO> dao_list(String mid, HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		List<GuestVO> list = sqlSession.selectList(mid, hm);
		return list;
	}

	@Override
	public GuestVO dao_findById(String mid, int num) {
		// TODO Auto-generated method stub
		GuestVO guest = sqlSession.selectOne(mid, num);
		return guest;
	}

	public int dao_count(String mid) {
		int count = sqlSession.selectOne(mid);
		return count;
	}

}
