package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberInsert extends AbstractController {
	private MemberDAOImpl dao;

	// setter
	// xml에서 세팅하고 거기 해당하는 값을 받아 세팅함
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO user = new MemberDTO();
		user.setId(req.getParameter("id"));
		user.setAddr(req.getParameter("addr"));
		user.setMemo(req.getParameter("memo"));
		user.setName(req.getParameter("name"));
		user.setPass(req.getParameter("pass"));

		dao.insert(user);
		return null;
	}

	public MemberDAOImpl getDao() {
		return dao;
	}

}
