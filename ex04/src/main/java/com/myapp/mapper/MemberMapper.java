package com.myapp.mapper;

import com.myapp.domain.AuthVO;
import com.myapp.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
//	회원가입
	public void register(MemberVO member);
//	회원 권한
	public void registerAuth(AuthVO auth);
//	아이디 중복체크
	public String idcheck(String id);
//	회원 수정
	public void modify(MemberVO member);
//	회원 권한 수정
	public void modifyAuth(AuthVO auth);
//	회원 탈퇴
	public void delete(MemberVO member);
//	회원 탈퇴 권한
	public void deleteAuth(String userid);
	
	
	

}
