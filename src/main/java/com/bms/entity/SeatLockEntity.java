package com.bms.entity;

import jakarta.persistence.Entity;

@Entity
public class SeatLockEntity {
	private long seatLockID;
	private String SeatID;
	private String userID;
	private String screenID;
	private String showID;
	public long getSeatLockID() {
		return seatLockID;
	}
	public void setSeatLockID(long seatLockID) {
		this.seatLockID = seatLockID;
	}
	public String getSeatID() {
		return SeatID;
	}
	public void setSeatID(String seatID) {
		SeatID = seatID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getScreenID() {
		return screenID;
	}
	public void setScreenID(String screenID) {
		this.screenID = screenID;
	}
	public String getShowID() {
		return showID;
	}
	public void setShowID(String showID) {
		this.showID = showID;
	}
	
	
	
}
