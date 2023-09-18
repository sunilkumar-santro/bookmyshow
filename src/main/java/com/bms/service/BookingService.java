package com.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto.Seat;
import com.bms.dto.UserBooking;
import com.bms.exception.SeatNotAvilableException;

@Service
public class BookingService {

	@Autowired
	SeatServcie seatServcie;

	public void createBooking(UserBooking userBooking) {

		List<Seat> avilableSeat = seatServcie.getAvilableSeat(userBooking.getScreenid(),userBooking.getShowid());
		
		List<Seat> selectedSeats = userBooking.getSelectedSeats();
		
		if(!avilableSeat.contains(selectedSeats)) {
			//throw new SeatNotAvilableException("Seat Already Booked");
		}
		
		// Create Booking.
		
		
		seatServcie.createBooking(userBooking.getScreenid(),userBooking.getShowid(),selectedSeats);
		
		
		// Call Payment Service for Payment service for Payment.
		
		
		// Call Notification Service for Notification (Ticker Confirmed).
		
		//Call Ticket Service to Generate Ticket.
		
		//Send Ticket on Mobile,EMail.
		
	

	}

}
