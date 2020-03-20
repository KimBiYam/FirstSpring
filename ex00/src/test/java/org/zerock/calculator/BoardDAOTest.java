package org.zerock.calculator;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.BoardDAO;
import org.zerock.model.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;

	@Test
	public void testInsertBoard() throws Exception {
		BoardDTO dto = new BoardDTO();
		dto.setContent("content");
		dto.setPassword("password");
		dto.setTitle("title");
		dto.setWriter("writer");
		dao.insertBoard("insertData", dto);

	}
}
    