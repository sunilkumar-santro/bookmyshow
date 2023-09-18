package com.bms.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
	private long showID;
	private Movie movie;
	private Screen screenID;
	private List<Seat> seats;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	
	
	public long getShowID() {
		return showID;
	}
	public void setShowID(long showID) {
		this.showID = showID;
	}

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Screen getScreenID() {
		return screenID;
	}
	public void setScreenID(Screen screenID) {
		this.screenID = screenID;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	
	
	
	
	
	
	
	

}
