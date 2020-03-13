package com.mybatis.model;

import java.util.List;

public interface MemberService {
	// 추가
	// 전체보기
	// 상세보기
	// 수정
	// 삭제
	public void insert(MemberVO member);

	public List<MemberVO> list(String field, String word);

	public MemberVO view(String id);

	public void update(MemberVO member);

	public void delete(String id);

}
