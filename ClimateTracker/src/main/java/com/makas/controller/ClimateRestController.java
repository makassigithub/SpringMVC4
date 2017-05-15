package com.makas.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makas.model.ClimatData;

@RestController//with this the methods automatically return a ResponseBody
public class ClimateRestController {
    
	@RequestMapping(value="/datas")
	public List <ClimatData> getAllClimateData(){
		List <ClimatData> clData = new ArrayList<ClimatData> ();
		ClimatData cd1 = new ClimatData();
		           cd1.setSeason("Summer");
		           cd1.setTemperature(34);
		ClimatData cd2 = new ClimatData();
		           cd2.setSeason("Winter");
		           cd2.setTemperature(-20);
		    clData.add(cd1);
		    clData.add(cd2);
		    
		    return clData;
 		           

	}
}
