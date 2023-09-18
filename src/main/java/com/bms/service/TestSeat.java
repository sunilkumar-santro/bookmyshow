package com.bms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.bms.dto.Seat;

public class TestSeat {

	public static void main(String[] args) {

		ConcurrentHashMap<String, Seat> seatINBooking = new ConcurrentHashMap<>();
//		Seat seat1 = new Seat();
//		seat1.setSeatNumber("SO1");
//		seatINBooking.put("SO1", seat1);

		Seat seat11 = new Seat();
		seat11.setSeatNumber("SO1");
		Seat seat2 = new Seat();
		seat2.setSeatNumber("SO2");
		Seat seat3 = new Seat();
		seat3.setSeatNumber("SO3");

		List<Seat> seats = new ArrayList<>();
		seats.add(seat11);
		seats.add(seat2);
		seats.add(seat3);


		seats.forEach(e -> {
			seatINBooking.put(e.getSeatNumber(), e);
		});
	
		System.out.println(seatINBooking);
	}
	


}

