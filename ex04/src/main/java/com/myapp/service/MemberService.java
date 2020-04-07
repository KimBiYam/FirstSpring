package com.myapp.service;

import com.myapp.domain.AuthVO;
import com.myapp.domain.MemberVO;

public interface MemberService {
	public void register(MemberVO member, AuthVO auth);

	public MemberVO get(String userid);

	public void modify(MemberVO member, AuthVO auth);

	public void delete(MemberVO member);

	public String idcheck(String userid);

}
