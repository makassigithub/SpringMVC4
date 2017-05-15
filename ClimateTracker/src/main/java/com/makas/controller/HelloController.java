package com.makas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value="/greet")
	public String sayHello (Model model) {
		System.out.println("inside sayHello");	
		model.addAttribute("greeting", "Hello Brahima");
		
		return "hello";
	}
	
	@RequestMapping(value="/salut")
	public String ditBonjour (Model model) {
			
		model.addAttribute("bonjour", "Salut Brahima");
		System.out.println("inside ditBonjour");	
		return "bonjour";
	}
	
	@RequestMapping(value="/index")
	//will grab the redirect from the /event url
	public String grabTheRedirect (Model model) {
		System.out.println("inside grabTheRedirect");
		System.out.println("this is the model from posted to event: "+ model);
		System.out.println("/event url redirected the to me: /index");
		System.out.println("I am forwarding to index.jsp..........");
		
		return "forward:index.jsp";
	}
}
