package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.person.vo.PersonVO;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private SqlSession sqlMap;

	@Override
	public void dao_insert(String mid, PersonVO person) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(mid, person);
//		sqlMap.commit();
	}

	@Override
	public List<PersonVO> dao_list(String mid, HashMap<String, String> map) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		List<PersonVO> list = sqlMap.selectList(mid, map);
		return list;
	}

	@Override
	public PersonVO dao_view(String mid, String id) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		PersonVO person = sqlMap.selectOne(mid, id);
		return person;
	}

	@Override
	public void dao_update(String mid, PersonVO person) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(mid, person);
//		sqlMap.commit();
	}

	@Override
	public void dao_delete(String mid, String id) {
		// TODO Auto-generated method stub
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.delete(mid, id);
//		sqlMap.commit();
	}

	public int dao_count(String mid, HashMap<String, String> map) {
//		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		int count = sqlMap.selectOne(mid, map);
		return count;
	}

}
