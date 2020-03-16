package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import com.guestapp.vo.GuestVO;

public interface GuestDAO {
	// 추가
	// 수정
	// 삭제
	// 전체보기(검색포함)
	// 상세보기
	public void dao_insert(GuestVO guest);

	public void dao_update(GuestVO guest);

	public void dao_delete(int num);

	public List<GuestVO> dao_list();

	public GuestVO dao_findById(int num);
}
