package com.mybatis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAOImpl dao;

	@Override
	public void insert(MemberVO member) {
		// TODO Auto-generated method stub
		dao.dao_insert("insertData", member);
	}

	@Override
	public List<MemberVO> list(String field, String word) {
		// TODO Auto-generated method stub
		List<MemberVO> list = dao.dao_list("listData", field, word);
		return list;
	}

	@Override
	public MemberVO view(String id) {
		// TODO Auto-generated method stub
		MemberVO user = dao.dao_view("viewData", id);
		return user;
	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub
		dao.dao_update("updateData", member);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.dao_delete("deleteData", id);
	}

}
