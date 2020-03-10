package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonVO;

//��Ʈ�ѷ� ����
@Controller
public class PersonController {
	//Autowired : �ڵ����� �ش� Ŭ������ ã�Ƽ� ��ü�� set����
	@Autowired
	private PersonDAOImpl dao;
	
	//�߰���
	@RequestMapping("personForm.go")
	public String PersonForm() {
		return "personForm";
	}
	
	//�߰�
	//method ��� ���� : RequestMethod
	@RequestMapping(value = "personInsert.go", method = RequestMethod.POST)
	public ModelAndView Inesrt(PersonVO person) {
		dao.person_insert(person);				
		return new ModelAndView("redirect:personList.go");		
	}
	
	//����Ʈ
	@RequestMapping(value = "personList.go", method = RequestMethod.GET)
	public ModelAndView List() {
		ModelAndView mv = new ModelAndView();
		List<PersonVO> list = dao.person_list();
		mv.addObject("list", list);
		mv.setViewName("personList");
		return mv;
	}
	
	//�󼼺���
	@RequestMapping("personView.go")
	public ModelAndView View(String id) {
		ModelAndView mv = new ModelAndView();
		PersonVO vo = dao.person_view(id);
		mv.addObject("dto",vo);
		mv.setViewName("personView");
		return mv; 
	}
	
	//����
	@RequestMapping(value = "personUpdate.go", method = RequestMethod.POST)
	public ModelAndView Update(PersonVO person) {
		dao.person_update(person);
		return new ModelAndView("redirect:personList.go");
	}
	
	//����
	@RequestMapping(value = "personDelete.go")
	public ModelAndView Delete(String id) {
		dao.person_delete(id);
		return new ModelAndView("redirect:personList.go");
	}
		
	
}
