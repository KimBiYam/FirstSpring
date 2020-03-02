package com.member.model;

import java.util.List;

public class MemberDAOImpl implements MemberDAO {

	// 전체보기
	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	// 상세보기
	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	// 추가
	@Override
	public void insert(MemberDTO user) {
		// TODO Auto-generated method stub
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		System.out.println("insert sql : " + sql);

	}

	// 수정
	@Override
	public void update(MemberDTO user) {
		// TODO Auto-generated method stub

	}

	// 삭제
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}