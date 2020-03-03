package com.member.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate template;

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// 전체보기
	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		String sql = "select * from springmember";
		List<MemberDTO> userlist = template.query(sql, new MemberRowMapper());
		return userlist;
	}

	// 상세보기
	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from springmember where id = ?";
		// String sql = "select * from springmember where id ='" + id+"'";
		MemberDTO user = template.queryForObject(sql, new Object[] { id }, new MemberRowMapper());
		return user;
	}

	// 추가
	@Override
	public void insert(MemberDTO user) {
		// TODO Auto-generated method stub
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param = new Object[] { user.getId(), user.getPass(), user.getName(), user.getAddr(), user.getMemo() };
		int i = template.update(sql, param);
		System.out.println(i + "개 행 삽입");
	}

	// 수정
	@Override
	public void update(MemberDTO user) {
		// TODO Auto-generated method stub
		String sql = "update springmember set addr=?,memo=? where id=?";
		Object[] param = new Object[] { user.getAddr(), user.getMemo(), user.getId() };
		int i = template.update(sql,param);
		System.out.println(i + "개 행 수정");
	}

	// 삭제
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete springmember where id=?";
		template.update(sql, new Object[] {id});
	}

}