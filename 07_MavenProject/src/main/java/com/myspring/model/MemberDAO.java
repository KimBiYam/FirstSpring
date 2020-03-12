package com.myspring.model;

import java.util.List;

public interface MemberDAO {
	//추가
	//전체보기
	//상세보기
	//수정
	//삭제
	public void dao_insert(MemberVO member);
	public List<MemberVO> dao_list();
	public MemberVO dao_view(String id);
	public void dao_update(MemberVO member);
	public void dao_delete(String id);

}
