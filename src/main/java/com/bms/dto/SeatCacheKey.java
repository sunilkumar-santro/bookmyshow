package com.bms.dto;

public final class SeatCacheKey {
	private final String screenID;
	private final String showID;
	private final String seatNumber;

	public SeatCacheKey(String screenID, String showID, String seatNumber) {
		this.screenID = screenID;
		this.showID = showID;
		this.seatNumber = seatNumber;
	}

	@Override
	public int hashCode() {
		return (screenID.concat(showID)).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		String sno = (String)obj;
		return seatNumber.equals(sno);
	}
	
	

}
