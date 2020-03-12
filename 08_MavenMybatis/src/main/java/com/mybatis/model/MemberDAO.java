package com.mybatis.model;

import java.util.List;

public interface MemberDAO {
	//�߰�
	//��ü����
	//�󼼺���
	//����
	//����
	public void dao_insert(String idName, MemberVO member);
	public List<MemberVO> dao_list(String idName);
	public MemberVO dao_view(String idName, String id);
	public void dao_update(String idName, MemberVO member);
	public void dao_delete(String idName, String id);

}
