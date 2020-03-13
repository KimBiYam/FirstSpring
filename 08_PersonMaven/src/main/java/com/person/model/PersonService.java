package com.person.model;

import java.util.HashMap;
import java.util.List;

import com.person.vo.PersonVO;

public interface PersonService {
	// 추가
	// 전체보기
	// 상세보기
	// 수정
	// 삭제
	public void insert(PersonVO person);

	public List<PersonVO> list(HashMap<String, String> map);

	public PersonVO view(String id);

	public void update(PersonVO person);

	public void delete(String id);
}
