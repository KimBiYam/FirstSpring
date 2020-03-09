package com.person.model;

import java.util.List;

public interface PersonDAO {
	//��ü����
	public List<PersonDTO> personList();
	//�߰�
	public void personInsert(PersonDTO person);
	//�󼼺���
	public PersonDTO personView(String id);
	//����
	public void personUpdate(PersonDTO person);
	//����
	public void personDelete(String id);
}
