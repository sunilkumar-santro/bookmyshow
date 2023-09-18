package com.bms.dto;

import java.util.List;


public class Theatre {
	
	public long theaterID;
	public String theaterName;
	public String City;
	public List<Screen> screens;
	
	
	public long getTheaterID() {
		return theaterID;
	}
	public void setTheaterID(long theaterID) {
		this.theaterID = theaterID;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public List<Screen> getScreens() {
		return screens;
	}
	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	
	
	
	
	
	

	
}
