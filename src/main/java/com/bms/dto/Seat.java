package com.bms.dto;

public class Seat {
	
	private long seatID;

	private String seatRow;

	private String seatNumber;

	private String seatType;

	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public String getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

}
