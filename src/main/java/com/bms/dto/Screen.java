package com.bms.dto;

import java.util.List;

public class Screen {
	private long screenid;
	private long totalSeats; 
	private List<Seat> seats;
	
	public long getScreenid() {
		return screenid;
	}
	public void setScreenid(long screenid) {
		this.screenid = screenid;
	}
	public long getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(long totalSeats) {
		this.totalSeats = totalSeats;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	

	

	
	
	
	
}
