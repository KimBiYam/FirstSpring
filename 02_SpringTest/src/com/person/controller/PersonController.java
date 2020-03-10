package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonVO;

//컨트롤러 선언
@Controller
public class PersonController {
	//Autowired : 자동으로 해당 클래스를 찾아서 객체를 set해줌
	@Autowired
	private PersonDAOImpl dao;
	
	//추가폼
	@RequestMapping("personForm.go")
	public String PersonForm() {
		return "personForm";
	}
	
	//추가
	//method 방식 설정 : RequestMethod
	@RequestMapping(value = "personInsert.go", method = RequestMethod.POST)
	public ModelAndView Inesrt(PersonVO person) {
		dao.person_insert(person);				
		return new ModelAndView("redirect:personList.go");		
	}
	
	//리스트
	@RequestMapping(value = "personList.go", method = RequestMethod.GET)
	public ModelAndView List() {
		ModelAndView mv = new ModelAndView();
		List<PersonVO> list = dao.person_list();
		mv.addObject("list", list);
		mv.setViewName("personList");
		return mv;
	}
	
	//상세보기
	@RequestMapping("personView.go")
	public ModelAndView View(String id) {
		ModelAndView mv = new ModelAndView();
		PersonVO vo = dao.person_view(id);
		mv.addObject("dto",vo);
		mv.setViewName("personView");
		return mv; 
	}
	
	//수정
	@RequestMapping(value = "personUpdate.go", method = RequestMethod.POST)
	public ModelAndView Update(PersonVO person) {
		dao.person_update(person);
		return new ModelAndView("redirect:personList.go");
	}
	
	//삭제
	@RequestMapping(value = "personDelete.go")
	public ModelAndView Delete(String id) {
		dao.person_delete(id);
		return new ModelAndView("redirect:personList.go");
	}
		
	
}
