package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService {
	@Autowired
	JdbcTemplate template;
	@Autowired
	private MemberDAOImpl dao;

	
	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return dao.getMemberList();
	}

	@Override
	public MemberVO detail(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void insert(MemberVO user) {
		// TODO Auto-generated method stub
		dao.insert(user);
	}

	@Override
	public void update(MemberVO user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
