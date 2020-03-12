package com.mybatis.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSessionFactory sqlMapper;

	@Override
	public void dao_insert(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(idName, member);
		session.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> list = session.selectList(idName);
		return list;
	}

	@Override
	public MemberVO dao_view(String idName, String id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO member = session.selectOne(idName, id);
		return member;
	}

	@Override
	public void dao_update(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.update(idName, member);
		session.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.delete(idName, id);
		session.commit();
	}
}
