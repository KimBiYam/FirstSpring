package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import com.guestapp.vo.GuestVO;

public interface GuestService {
	// 추가
	// 수정
	// 삭제
	// 전체보기(검색포함)
	// 상세보기
	public void insert(GuestVO guest);
	public void update(GuestVO guest);
	public void delete(int num);
	public List<GuestVO> list(HashMap<String, Object> hm);
	public GuestVO findById(int num);
}
