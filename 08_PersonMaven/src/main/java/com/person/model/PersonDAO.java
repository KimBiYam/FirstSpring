package com.person.model;

import java.util.HashMap;
import java.util.List;

import com.person.vo.PersonVO;

public interface PersonDAO {
	// �߰�
	// ��ü����
	// �󼼺���
	// ����
	// ����
	public void dao_insert(String mid, PersonVO person);

	public List<PersonVO> dao_list(String mid, HashMap<String, String> map);

	public PersonVO dao_view(String mid, String id);

	public void dao_update(String mid, PersonVO person);

	public void dao_delete(String mid, String id);

}
