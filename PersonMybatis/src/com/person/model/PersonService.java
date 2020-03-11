package com.person.model;

import java.util.List;

public interface PersonService {
	public void person_insert(PersonVO person);

	public List<PersonVO> person_list();

	public PersonVO person_view(String id);

	public void person_update(PersonVO person);

	public void person_delete(String id);

}
