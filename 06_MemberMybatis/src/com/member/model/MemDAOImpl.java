package com.member.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemDAOImpl implements MemDAO {
	@Autowired
	private SqlSessionFactory sqlMapper;

	@Override
	public void dao_insert(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		//이미 만들어 져 있을 시 재사용하라는 의미
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(idName,member);
		sess.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		// TODO Auto-generated method stub
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> mlist = sess.selectList(idName);
		return mlist;
	}

	@Override
	public MemberVO dao_view(String idName, String id) {
		// TODO Auto-generated method stub
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO mUser = sess.selectOne(idName,id);
		return mUser;
	}

	@Override
	public void dao_update(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(idName, member);
		sess.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		// TODO Auto-generated method stub
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(idName,id);
		sess.commit();
	}

	

}

