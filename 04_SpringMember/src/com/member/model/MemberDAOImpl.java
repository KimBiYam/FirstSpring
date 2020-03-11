package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// @Repository() 괄호 넣어도되고 지워도 됨
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		String sql = "select * from springmember order by id";
		List<MemberVO> userlist = template.query(sql, new MemberRowMapper());
		return userlist;
	}

	@Override
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from springmember where id='" + id + "'";
		MemberVO user = template.queryForObject(sql, new MemberRowMapper());
		return user;
	}

	@Override
	public void insert(MemberVO user) {
		// TODO Auto-generated method stub
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param = new Object[] { user.getId(), user.getPass(), user.getName(), user.getAddr(), user.getMemo() };
		template.update(sql, param);
	}

	@Override
	public void update(MemberVO user) {
		// TODO Auto-generated method stub
		String sql = "update springmember set pass=?,name=?,addr=?,memo=? where id=?";
		Object[] param = new Object[] { user.getPass(), user.getName(), user.getAddr(), user.getMemo(), user.getId() };
		template.update(sql, param);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete springmember where id='"+id+"'";
		template.update(sql);
	}

}
