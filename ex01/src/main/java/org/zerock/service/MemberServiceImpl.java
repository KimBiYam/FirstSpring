package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper mapper;

	@Override
	public void register(MemberVO member) {
		// TODO Auto-generated method stub
		mapper.register(member);
	}

	@Override
	public MemberVO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
