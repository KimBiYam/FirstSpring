package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guestapp.mapper.GuestMapper;
import com.guestapp.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO {
	@Autowired
	private GuestMapper mapper;
		

	@Override
	public void dao_insert(GuestVO guest) {
		// TODO Auto-generated method stub
		mapper.insert(guest);
	}

	@Override
	public void dao_update(GuestVO guest) {
		// TODO Auto-generated method stub
		mapper.update(guest);
	}

	@Override
	public void dao_delete(int num) {
		// TODO Auto-generated method stub
		mapper.delete(num);
	}

	@Override
	public List<GuestVO> dao_list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public GuestVO dao_findById(int num) {
		// TODO Auto-generated method stub
		return mapper.view(num);
	}

}
