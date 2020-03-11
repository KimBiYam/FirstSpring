package com.person.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.person.config.MybatisManager;

@Repository
public class PersonDAOImpl implements PersonDAO {
	private SqlSession sqlMap;

	public PersonDAOImpl() {
		SqlSessionFactory sqlMapper = MybatisManager.getMapper();
		sqlMap = sqlMapper.openSession();
	}

	@Override
	public void dao_insert(String idName, PersonVO person) {
		// TODO Auto-generated method stub
		sqlMap.insert(idName, person);
		sqlMap.commit();
	}

	@Override
	public List<PersonVO> dao_list(String idName) {
		// TODO Auto-generated method stub
		List<PersonVO> list = sqlMap.selectList(idName);
		return list;
	}

	@Override
	public PersonVO dao_view(String idName, String id) {
		// TODO Auto-generated method stub
		PersonVO person = sqlMap.selectOne(idName, id);
		return person;
	}

	@Override
	public void dao_update(String idName, PersonVO person) {
		// TODO Auto-generated method stub
		sqlMap.update(idName, person);
		sqlMap.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		// TODO Auto-generated method stub
		sqlMap.delete(idName,id);
		sqlMap.commit();
	}

}
