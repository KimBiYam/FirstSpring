package com.myapp.service;

import com.myapp.domain.Criteria;
import com.myapp.domain.ReplyPageDTO;
import com.myapp.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
