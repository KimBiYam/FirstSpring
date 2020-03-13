package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDAOImpl dao;

	@Override
	public void insert(PersonVO person) {
		// TODO Auto-generated method stub
		dao.dao_insert("insertPerson", person);
	}

	@Override
	public List<PersonVO> list(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		List<PersonVO> list = dao.dao_list("listPerson", map);
		return list;
	}

	@Override
	public PersonVO view(String id) {
		// TODO Auto-generated method stub
		PersonVO person = dao.dao_view("viewPerson", id);
		return person;
	}

	@Override
	public void update(PersonVO person) {
		// TODO Auto-generated method stub
		dao.dao_update("updatePerson", person);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.dao_delete("deletePerson", id);

	}

	public int count(HashMap<String, String> map) {
		int count = dao.dao_count("countPerson", map);
		return count;
	}

}
