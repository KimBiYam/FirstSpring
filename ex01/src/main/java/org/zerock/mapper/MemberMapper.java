package org.zerock.mapper;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
//	ȸ������
	public void register(MemberVO member);
//	ȸ������
	public MemberVO get(String id);
//	���̵� �ߺ�üũ
	public String idcheck(String id);
//	ȸ�� ����
	public void modify(MemberVO member);
//	ȸ�� Ż��
	public void delete(MemberVO member);
}
