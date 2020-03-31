package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public void insert(MemberVO mvo);
	public void authInsert(@Param("userid") String userid,
			@Param("auth") String auth);
}
