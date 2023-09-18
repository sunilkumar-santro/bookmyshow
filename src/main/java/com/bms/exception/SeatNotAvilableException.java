package com.bms.exception;

public class SeatNotAvilableException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public SeatNotAvilableException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
