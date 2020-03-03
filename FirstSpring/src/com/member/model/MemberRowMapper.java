package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MemberDTO user = new MemberDTO();
		user.setId(rs.getString(1));
		user.setName(rs.getString("name"));
		user.setMemo(rs.getString("memo"));
		user.setAddr(rs.getString("addr"));
		user.setReg_date(rs.getString("reg_date"));
		user.setPass(rs.getString("pass"));
		return user;
	}
		

}

