package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDTO user = new MemberDTO();
		user.setAddr(req.getParameter("addr"));
		user.setId(req.getParameter("id"));
		user.setMemo(req.getParameter("memo"));
		user.setName(req.getParameter("name"));
		user.setPass(req.getParameter("pass"));
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		dao.insert(user);
		resp.sendRedirect("member_list.ser");
	}
}
