package com.person.model;

import java.util.List;

public interface PersonDAO {
	// 추가
	// 전체보기
	// 상세보기
	// 수정
	// 삭제
	public void dao_insert(String idName, PersonVO person);

	public List<PersonVO> dao_list(String idName);

	public PersonVO dao_view(String idName, String id);

	public void dao_update(String idName, PersonVO person);

	public void dao_delete(String idName, String id);

}
