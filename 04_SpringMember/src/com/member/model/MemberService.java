package com.member.model;

import java.util.List;

public interface MemberService {
	List<MemberVO> list();
	MemberVO detail(String id);
	void insert(MemberVO user);
	void update(MemberVO user);
	void delete(String id);	
}
