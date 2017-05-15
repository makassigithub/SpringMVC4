package com.makas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makas.model.ClimatData;

@Controller
public class ClimateController {

	@RequestMapping (value="/climat" ,method = RequestMethod.GET)
	public String getClimateForm(Model model) {
		ClimatData cdata = new ClimatData();
		          // cdata.setSeason("Summer");
		          // cdata.setTemperature(32);
		 model.addAttribute("time", cdata);
		 
		 return "climatePage";
		  
		
	}
	
	@RequestMapping (value="/climat" ,method = RequestMethod.POST)
	public String getClimateData(
			
			@Valid @ModelAttribute("time") ClimatData climatdata, BindingResult result,
			Model model) {
		  
		 if(result.hasErrors()) {
			return "climatePage" ;
		 }
		 System.out.println(climatdata);
		 return "redirect:index.html";
		  
		
	}
}
