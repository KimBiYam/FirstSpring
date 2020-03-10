package com.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Repository : 자동으로 bean 정의 등록
@Repository()
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private JdbcTemplate template;

	// 추가
	@Override
	public void person_insert(PersonVO person) {
		// TODO Auto-generated method stub
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] { person.getId(), person.getName(), person.getPassword(), person.getGender(),
				person.getJob() };
		template.update(sql, param);
	}

	// 전체보기
	@Override
	public List<PersonVO> person_list() {
		// TODO Auto-generated method stub
		String sql = "select * from person order by id";
		List<PersonVO> list = template.query(sql, new PersonRowMapper());
		return list;
	}

	// 상세보기
	@Override
	public PersonVO person_view(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from person where id='" + id + "'";
		PersonVO person = template.queryForObject(sql, new PersonRowMapper());
		return person;
	}
	
	// 수정
	@Override
	public void person_update(PersonVO person) {
		// TODO Auto-generated method stub
		String sql = "update person set name=?,password=?,gender=?,job=? where id=?";
		Object[] param = new Object[] {
				person.getName(),person.getPassword(),person.getGender(),person.getJob(),person.getId()
		};
		template.update(sql,param);
	}

	// 삭제
	@Override
	public void person_delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete person where id='"+id+"'";
		template.update(sql);	
	}

}
