package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	public void register(MemberVO member);
	
	public MemberVO get(String id);	

}
