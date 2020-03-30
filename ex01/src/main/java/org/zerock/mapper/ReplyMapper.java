package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//�߰�
	//�󼼺���
	//����
	//����
	//����Ʈ

	public int insert(ReplyVO vo);

	public ReplyVO read(Long rno);

	public int delete(Long rno);

	public int update(ReplyVO reply);

	public List<ReplyVO> getList(Criteria cri, Long bno);

	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);

	//����
	public int getCountByBno(Long bno);
	//�� ���� �� ��� ����
	public void deleteByBno(Long bno);
	//ȸ�� Ż�� �� ��� ����
	public void deleteById(String id);
	//ȸ�� �̸� ���� �� ������Ʈ
	public void updateName(MemberVO member);	
	
	
}