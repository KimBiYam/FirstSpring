package com.person.model;

import java.util.List;

public interface PersonDAO {
	//�߰�
	public void person_insert(PersonVO person);
	//��ü����
	public List<PersonVO> person_list();
	//�󼼺���
	public PersonVO person_view(String id);
	//����
	public void person_update(PersonVO person);
	//����
	public void person_delete(String id);
}
