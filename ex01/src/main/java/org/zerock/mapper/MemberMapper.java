package org.zerock.mapper;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public void register(MemberVO member);
	
	public void get(String id);

}
