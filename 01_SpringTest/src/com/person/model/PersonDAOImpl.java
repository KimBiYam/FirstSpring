package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class PersonDAOImpl implements PersonDAO {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void personInsert(PersonDTO person) {
		// TODO Auto-generated method stub
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] { person.getId(), person.getName(), person.getPassword(), person.getGender(),
				person.getJob() };
		int i = template.update(sql, param);
		System.out.println(i + "개 행 삽입");
	}

	@Override
	public PersonDTO personView(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from person where id="+id;
		PersonDTO person = template.queryForObject(sql, new PersonRowMapper());
		return person;
	}

	@Override
	public void personUpdate(PersonDTO person) {
		// TODO Auto-generated method stub
		String sql = "update person set name=?,password=?,gender=?,job=? where id=?";
		Object[] param = new Object[] { person.getName(), person.getPassword(), person.getGender(), person.getJob(),
				person.getId() };
		int i = template.update(sql, param);
		System.out.println(i + "개 행 삽입");
	}

	@Override
	public void personDelete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete person where id="+id;
		int i = template.update(sql);
		System.out.println(i + "개 행 삭제");
	}

	@Override
	public List<PersonDTO> personList() {
		// TODO Auto-generated method stub
		String sql = "select * from person";
		// 따로 RowMapper 클래스를 만들지않고 anonymous 방식으로 직접 만들어줌
		List<PersonDTO> list = template.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				PersonDTO person = new PersonDTO();
				person.setGender(rs.getString("gender"));
				person.setId(rs.getString("id"));
				person.setJob(rs.getString("job"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
				return person;				
			}
			
		});
		return list;
	}
	


}
