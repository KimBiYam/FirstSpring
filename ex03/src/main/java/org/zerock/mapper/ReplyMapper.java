package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//추가
	//상세보기
	//삭제
	//수정
	//리스트

	public int insert(ReplyVO vo);

	public ReplyVO read(Long rno);

	public int delete(Long rno);

	public int update(ReplyVO reply);

	public List<ReplyVO> getList(Criteria cri, Long bno);

	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);

	//갯수
	public int getCountByBno(Long bno);
	
	//글 삭제 시 댓글 삭제
	public void deleteByBno(Long bno);
	
	
}
