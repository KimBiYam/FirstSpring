package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.MemberMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;

	@Override
	public void register(MemberVO member) {
		// TODO Auto-generated method stub
		mapper.register(member);
	}

	@Override
	public MemberVO get(String id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}
	
	public String idcheck(String id) {
		return mapper.idcheck(id);
	}

	@Transactional
	@Override
	public void modify(MemberVO member) {
		// TODO Auto-generated method stub
		replyMapper.updateName(member);
		boardMapper.updateName(member);
		mapper.modify(member);
				
	}

	@Transactional	
	@Override
	public void delete(MemberVO member) {
		// TODO Auto-generated method stub
		replyMapper.deleteById(member.getId());
		boardMapper.deleteById(member.getId());
		mapper.delete(member);
	}
	
	

}
