package com.bms.dto;

import java.util.List;

public class ShowSeat {

	private long showID;
	private List<Seat> seats;

	public long getShowID() {
		return showID;
	}

	public void setShowID(long showID) {
		this.showID = showID;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
