package com.bms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.controller.repository.SeatLockerRepo;
import com.bms.controller.repository.SeatRepo;
import com.bms.dto.Seat;
import com.bms.entity.SeatLockEntity;

public class SeatServcie {

	@Autowired
	ShowService showService;

	@Autowired
	SeatLockerRepo seatLockerRepo;

	@Autowired
	SeatRepo seatRepo;

	ConcurrentHashMap<String, Seat> seatINBooking = new ConcurrentHashMap<>();

	public synchronized List<Seat> getAvilableSeat(String screenID, String showid) {

		List<Seat> seats = showService.getShowSeats(screenID, showid);

		// Fetched available Seat,Those are not confirmed ,Not Locked.
		// Remove those Seat those are in current Booking

		seats = seats.stream().filter(st -> !seatINBooking.containsKey(st.getSeatNumber()))
				.collect(Collectors.toList());
		return seats;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void createBooking(String screenid, String showid, List<Seat> selectedSeats) {

		// We have to Perform Multiple Action on Seat Booking.

		// Update the inmemory Cache.

		selectedSeats.stream().map(e -> seatINBooking.put(e.getSeatNumber(), e)).close();

		// Lock the Seat in Cache.

		// seatLockerRepo.Lock the Seat(String screenid, String showid, List<Seat>
		// selectedSeats)

		// Update User Seat Table , Status Confirmed.
		List<SeatLockEntity> seatLokedList = new ArrayList<>();
		// populate Seat Those We have to Locked.
		seatLockerRepo.saveAll(seatLokedList);

	}

	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void CancelBooking(String screenid, String showid, List<Seat> selectedSeats) {



		// Update the inmemory Cache, Remove Locked Seat

		selectedSeats.stream().map(e -> seatINBooking.remove(e.getSeatNumber())).close();


		// Update User Seat Table , Status Available.
		List<SeatLockEntity> seatLokedList = new ArrayList<>();
		// populate Seat Those We have to Locked.
		seatLockerRepo.deleteAll(seatLokedList);

	}

}
