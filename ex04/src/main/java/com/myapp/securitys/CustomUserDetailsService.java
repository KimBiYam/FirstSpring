package com.myapp.securitys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myapp.domain.MemberVO;
import com.myapp.mapper.MemberMapper;
import com.myapp.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + username);
		// userName means userid
		MemberVO vo = memberMapper.read(username);
		return vo == null ? null : new CustomUser(vo);
	}

}
