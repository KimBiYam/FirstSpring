package com.myapp.mapper;

import com.myapp.domain.AuthVO;
import com.myapp.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
//	ȸ������
	public void register(MemberVO member);
//	ȸ�� ����
	public void registerAuth(AuthVO auth);
//	���̵� �ߺ�üũ
	public String idcheck(String id);
//	ȸ�� ����
	public void modify(MemberVO member);
//	ȸ�� ���� ����
	public void modifyAuth(AuthVO auth);
//	ȸ�� Ż��
	public void delete(MemberVO member);
//	ȸ�� Ż�� ����
	public void deleteAuth(String userid);
	
	
	

}
