package com.mybatis.model;

import java.util.List;

public interface MemberService {
	// �߰�
	// ��ü����
	// �󼼺���
	// ����
	// ����
	public void insert(MemberVO member);

	public List<MemberVO> list(String field, String word);

	public MemberVO view(String id);

	public void update(MemberVO member);

	public void delete(String id);

}
