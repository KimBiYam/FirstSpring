package com.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.domain.Criteria;
import com.myapp.domain.ReplyVO;
import com.myapp.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper replyMapper;
	
	@Override	
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return replyMapper.delete(rno);
	}

	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		System.out.println(bno);
		System.out.println(cri.getAmount());
		System.out.println(cri.getPageNum());
		return replyMapper.getListWithPaging(cri, bno);
		
	}
	
	

}
