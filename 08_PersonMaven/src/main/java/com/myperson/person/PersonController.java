package com.myperson.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	@RequestMapping("personForm.go")
	public String insert() {
		return "personForm";
	}
	
	

}
