package com.makas.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ClimatData {
	
	@NotNull
	private int temperature;
	
	@Size(min=2,max=5)
	private String season;
	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	

}
