package com.bms.dto;

import java.util.List;

public class UserBooking {

	private User user;
	private String screenid;
	private String showid;
	
	private List<Seat> selectedSeats;
	

	public List<Seat> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(List<Seat> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getScreenid() {
		return screenid;
	}

	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}

	public String getShowid() {
		return showid;
	}

	public void setShowid(String showid) {
		this.showid = showid;
	}


}
