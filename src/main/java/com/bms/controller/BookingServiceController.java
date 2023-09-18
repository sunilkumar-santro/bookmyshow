package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.UserBooking;
import com.bms.service.BookingService;

@RestController
@RequestMapping("/bookmyshow/bookingservice")
public class BookingServiceController {
	
	@Autowired
	BookingService bookingService;

	public ResponseEntity<String> createBooking(@RequestBody UserBooking userBooking) {
		
		bookingService.createBooking(userBooking);
		

		return new ResponseEntity<>("Booking Created Download the Tickets", HttpStatus.ACCEPTED);
	}

}
