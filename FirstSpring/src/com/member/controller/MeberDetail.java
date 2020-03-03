package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MeberDetail extends AbstractController {
	MemberDAOImpl dao;

	// setter
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		MemberDTO user = dao.findById(id);
		ModelAndView mv = new ModelAndView();		
		mv.addObject("user", user);
		mv.setViewName("WEB-INF/jsp/detail.jsp");

		return mv;
	}

}
