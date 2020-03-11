package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemServiceImpl implements MemService{
	@Autowired
	private MemDAOImpl mDao;
	
	@Override
	public void insert(MemberVO member) {
		// TODO Auto-generated method stub
		mDao.dao_insert("insertData", member);
	}

	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return mDao.dao_list("listData");
	}

	@Override
	public MemberVO view(String id) {
		// TODO Auto-generated method stub
		return mDao.dao_view("viewData", id);
	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub
		mDao.dao_update("updateData", member);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		mDao.dao_delete("deleteData", id);
	}

}
