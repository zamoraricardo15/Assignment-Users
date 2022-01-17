package com.rick.sbf.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

@RequestMapping("/")

public class HumanController {
	

	@RequestMapping("")
	public String nameInput(Model model, @RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String last_name) {
		if (name == null) {  
			
			model.addAttribute("name", "Human");
			return "main.jsp";
			
		
		} else  
			model.addAttribute("name", name);
		
			model.addAttribute("last_name", last_name);
			
				return "main.jsp";	
	}

}

//http://localhost:8080/