package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

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
	public List<GuestVO> dao_list(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return mapper.list(hm);
	}

	@Override
	public GuestVO dao_findById(int num) {
		// TODO Auto-generated method stub
		return mapper.view(num);
	}
	
	public int dao_count(HashMap<String, Object> hm) {
		return mapper.count(hm);		
	}

}
