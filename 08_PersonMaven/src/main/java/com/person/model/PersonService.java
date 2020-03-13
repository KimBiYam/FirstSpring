package com.person.model;

import java.util.HashMap;
import java.util.List;

import com.person.vo.PersonVO;

public interface PersonService {
	// �߰�
	// ��ü����
	// �󼼺���
	// ����
	// ����
	public void insert(PersonVO person);

	public List<PersonVO> list(HashMap<String, String> map);

	public PersonVO view(String id);

	public void update(PersonVO person);

	public void delete(String id);
}
