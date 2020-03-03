package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberUpdate extends AbstractController{
	MemberDAOImpl dao;

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
		
		dao.update(user);
		
		return new ModelAndView("redirect:member_list.do");
	}

}
