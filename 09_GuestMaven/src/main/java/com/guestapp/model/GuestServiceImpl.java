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
		dao.dao_insert("guestInsert", guest);
	}

	@Override
	public void update(GuestVO guest) {
		// TODO Auto-generated method stub
		dao.dao_update("guestUpdate", guest);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		dao.dao_delete("guestDelete", num);
	}

	@Override
	public List<GuestVO> list(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		List<GuestVO> list = dao.dao_list("guestList", hm);
		return list;
	}

	@Override
	public GuestVO findById(int num) {
		// TODO Auto-generated method stub
		GuestVO guest = dao.dao_findById("guestView", num);
		return guest;
	}
	
	public int count() {
		int count = dao.dao_count("guestCount");
		return count;
	}

}
