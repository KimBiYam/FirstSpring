package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestapp.vo.GuestVO;

@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	GuestDAOImpl dao;

	@Override
	public void insert(GuestVO guest) {
		// TODO Auto-generated method stub
		dao.dao_insert(guest);
	}

	@Override
	public void update(GuestVO guest) {
		// TODO Auto-generated method stub
		dao.dao_update(guest);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		dao.dao_delete(num);
	}

	@Override
	public List<GuestVO> list() {
		// TODO Auto-generated method stub
		return dao.dao_list();
	}

	@Override
	public GuestVO findById(int num) {
		// TODO Auto-generated method stub
		GuestVO guest = dao.dao_findById(num);
		return guest;
	}
	

}
