package com.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDAOImpl dao;

	@Override
	public void person_insert(PersonVO person) {
		// TODO Auto-generated method stub
		dao.dao_insert("personInsert", person);
	}

	@Override
	public List<PersonVO> person_list() {
		// TODO Auto-generated method stub
		return dao.dao_list("personList");
	}

	@Override
	public PersonVO person_view(String id) {
		// TODO Auto-generated method stub
		return dao.dao_view("personView", id);
	}

	@Override
	public void person_update(PersonVO person) {
		// TODO Auto-generated method stub
		dao.dao_update("personUpdate", person);
	}

	@Override
	public void person_delete(String id) {
		// TODO Auto-generated method stub
		dao.dao_delete("personDelete", id);
	}

}
