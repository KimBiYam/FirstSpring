package com.member.model;

import java.util.List;

public interface MemService {
	//�߰�
	//��ü����
	//�󼼺���
	//����
	//����
	public void insert(MemberVO member);
	public List<MemberVO> list();
	public MemberVO view(String id);
	public void update(MemberVO member);
	public void delete(String id);	
}
