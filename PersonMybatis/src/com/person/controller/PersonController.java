package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person.model.PersonServiceImpl;
import com.person.model.PersonVO;

@Controller
public class PersonController {
	@Autowired
	private PersonServiceImpl pService;
	
	
	//�߰���
	@RequestMapping("personForm.mb")
	public void insert() {
		
	}
	
	//�߰�
	@RequestMapping(value = "personInsert.mb", method = RequestMethod.POST)
	public String insert(PersonVO person) {
		pService.person_insert(person);
		return "redirect:personList.mb";
	}
	
	//����Ʈ
	@RequestMapping("personList.mb")
	public String list(Model model) {
		List<PersonVO> list = pService.person_list();
		model.addAttribute("list", list);
		return "personList";
	}
	
	//�󼼺���
	@RequestMapping("personView.mb")
	public String view(Model model, String id) {
		PersonVO person = pService.person_view(id);
		model.addAttribute("dto",person);
		return "personView";
	}
	
	//������Ʈ
	@RequestMapping(value =  "personUpdate.mb", method = RequestMethod.POST)
	public String update(PersonVO person) {
		pService.person_update(person);
		return "redirect:personList.mb";
	}
	
	//����
	@RequestMapping(value = "personDelete.mb")
	public String delete(String id) {
		pService.person_delete(id);
		return "redirect:personList.mb"; 
	}
	
	

}
