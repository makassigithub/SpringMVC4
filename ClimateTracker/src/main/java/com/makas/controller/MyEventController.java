package com.makas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.makas.model.MyEvent;

@Controller
@SessionAttributes("first") //could add many object using an array
public class MyEventController {

	
	@RequestMapping(value="/event",method=RequestMethod.GET)
	public String displayEvent (Model model) {
		System.out.println("INSIDE MY CONTROLLER");
		MyEvent myEve = new MyEvent();
		        myEve.setName("gaming");
		        
		        //the key of the model (first) use to map for my object will be 
		        //to the form in the view with the commandName parameter use to bind the model
		        model.addAttribute("first", myEve);
		        
		return "eventPage";
	}
	
	@RequestMapping(value="/event",method=RequestMethod.POST)
	public String manageEvent (@ModelAttribute("first") MyEvent evt) {
		System.out.println(evt);
		
		//form this line, send the url index.html
		//if we forget the .html, the dispacther servlet will refuse our url
		System.out.println("inside manageEvent to manage the post /event");
		System.out.println("i received this binding object from the browser: "+evt);
		System.out.println("redirecting to /index");
		return "redirect:index.html";
	}
	
}
