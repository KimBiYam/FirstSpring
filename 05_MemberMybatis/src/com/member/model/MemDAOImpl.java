package com.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.member.config.MybatisManager;

@Repository
public class MemDAOImpl implements MemDAO {
	private SqlSession sqlMap;

	public MemDAOImpl() {
		SqlSessionFactory sqlMapper = MybatisManager.getMapper();
		sqlMap = sqlMapper.openSession();
	}	

	@Override
	public void dao_insert(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		sqlMap.insert(idName,member);
		sqlMap.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		// TODO Auto-generated method stub
		List<MemberVO> mlist = sqlMap.selectList(idName);
		return mlist;
	}

	@Override
	public MemberVO dao_view(String idName, String id) {
		// TODO Auto-generated method stub
		MemberVO mUser = sqlMap.selectOne(idName,id);
		return mUser;
	}

	@Override
	public void dao_update(String idName, MemberVO member) {
		// TODO Auto-generated method stub
		sqlMap.update(idName, member);
		sqlMap.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		// TODO Auto-generated method stub
		sqlMap.delete(idName,id);
		sqlMap.commit();
	}

	

}

