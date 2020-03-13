package com.myperson.person;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person.model.PersonServiceImpl;
import com.person.vo.PersonVO;

@Controller
public class PersonController {
	@Autowired // @Resource,@Inject

	PersonServiceImpl service;

	// �߰� ��
	@RequestMapping("personForm.go")
	public String insert() {
		return "personForm";
	}

	// �߰�
	@RequestMapping(value = "personInsert.go", method = RequestMethod.POST)
	public String insert(PersonVO person) {
		service.insert(person);
		return "redirect:personList.go";
	}

	// ����Ʈ
	@RequestMapping("personList.go")
	public String list(Model model, String field, String word) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("field", field);
		map.put("word", word);
		List<PersonVO> list = service.list(map);
		int count = service.count(map);
		model.addAttribute("personlist", list);
		model.addAttribute("count", count);
		return "personList";
	}

	// �󼼺���
	@RequestMapping("personView.go")
	public String view(Model model, String id) {
		PersonVO person = service.view(id);
		model.addAttribute("person", person);
		return "personView";
	}

	// ���� ��
	@RequestMapping("personUpdate.go")
	public String update(Model model, String id) {
		PersonVO person = service.view(id);
		model.addAttribute("person", person);
		return "personUpdate";
	}

	// ����
	@RequestMapping(value = "personUpdate.go", method = RequestMethod.POST)
	public String update(PersonVO person) {
		service.update(person);
		return "redirect:personList.go";
	}

	// ����
	@RequestMapping("personDelete.go")
	public String delete(String id) {
		service.delete(id);
		return "redirect:personList.go";
	}

}
