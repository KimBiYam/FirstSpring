package com.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapp.domain.AuthVO;
import com.myapp.domain.MemberVO;
import com.myapp.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	

	@Override
	public void register(MemberVO member, AuthVO auth) {
		// TODO Auto-generated method stub
		member.setUserpw(pwencoder.encode(member.getUserpw()));
		mapper.register(member);
		mapper.registerAuth(auth);
	}

	@Override
	public MemberVO get(String userid) {
		// TODO Auto-generated method stub
		return mapper.read(userid);
	}

	@Override
	public void modify(MemberVO member, AuthVO auth) {
		// TODO Auto-generated method stub
		mapper.modify(member);
		mapper.modifyAuth(auth);
	}

	@Override
	public void delete(MemberVO member) {
		// TODO Auto-generated method stub
		mapper.delete(member);
		mapper.deleteAuth(member.getUserid());
	}

	@Override
	public String idcheck(String userid) {
		// TODO Auto-generated method stub
		return mapper.idcheck(userid);
	}

}
