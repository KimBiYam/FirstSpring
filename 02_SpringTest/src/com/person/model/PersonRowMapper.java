package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<PersonVO> {

	@Override
	public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		PersonVO person = new PersonVO();
		person.setGender(rs.getString("gender"));
		person.setId(rs.getString("id"));
		person.setJob(rs.getString("job"));
		person.setName(rs.getString("name"));
		person.setPassword(rs.getString("password"));
		return person;
	}

}
