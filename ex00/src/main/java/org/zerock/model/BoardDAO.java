package org.zerock.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession; 
	
	public void insertBoard(String mid, BoardDTO dto) {
		sqlSession.insert(mid,dto);
	}

}
