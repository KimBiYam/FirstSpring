package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberFormUpdate extends AbstractController {
	MemberDAOImpl dao;
	
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		MemberDTO user = dao.findById(id);
		mv.addObject("user", user);
		mv.setViewName("WEB-INF/jsp/memberUpdate.jsp");

		return mv;
	}

}
