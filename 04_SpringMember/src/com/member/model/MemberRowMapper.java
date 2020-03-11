package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO();
		vo.setAddr(rs.getString("addr"));
		vo.setId(rs.getString("id"));
		vo.setMemo(rs.getString("memo"));
		vo.setName(rs.getString("name"));
		vo.setPass(rs.getString("pass"));
		vo.setReg_date(rs.getString("reg_date"));
		return vo;
	}

}
