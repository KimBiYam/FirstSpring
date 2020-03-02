package com.member.model;

import java.util.List;

public interface MemberDAO {
	List<MemberDTO> getMemberList();
	MemberDTO findById(String id);
	void insert(MemberDTO user);	
	void update(MemberDTO user);
	void delete(String id);		
}
