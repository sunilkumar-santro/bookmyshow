package com.bms.service;

import java.time.LocalTime;
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
import com.bms.dto.SeatCacheKey;
import com.bms.entity.SeatLockEntity;

public class SeatServcie {

	@Autowired
	ShowService showService;

	@Autowired
	SeatLockerRepo seatLockerRepo;

	@Autowired
	SeatRepo seatRepo;

	ConcurrentHashMap<SeatCacheKey, LocalTime> seatBookingInMemoryCache = new ConcurrentHashMap<>();

	public List<Seat> getAvilableSeat(String screenID, String showid) {

		List<Seat> seats = showService.getShowSeats(screenID, showid);

		// Fetched available Seat,Those are Available ,Not Locked.
		// Remove those Seat those are in current Booking

		seats = seats.stream().filter(
				st -> !seatBookingInMemoryCache.containsKey(new SeatCacheKey(screenID, showid, st.getSeatNumber())))
				.collect(Collectors.toList());
		return seats;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void createBooking(String screenid, String showid, List<Seat> selectedSeats) {

		// We have to Perform Multiple Action on Seat Booking.

		// Update the inmemory Cache.

		if (!isselectedSeatsAvilable(selectedSeats)) {
			// Selected Seat are booking in Progress.
			// Throw Exception - THis Seat is selected by some one else, Please Select
		}

		selectedSeats.forEach(e -> {
			seatBookingInMemoryCache.put(new SeatCacheKey(screenid, showid, e.getSeatNumber()), LocalTime.now());
		});

		// Lock the Seat in Cache.

		// seatLockerRepo.Lock the Seat(String screenid, String showid, List<Seat>
		// selectedSeats)

		// Update User Seat Table , Status Confirmed.
		List<SeatLockEntity> seatLokedList = new ArrayList<>();
		// populate Seat Those We have to Locked.
		seatLockerRepo.saveAll(seatLokedList);

	}

	private boolean isselectedSeatsAvilable(List<Seat> selectedSeats) {
		long lockedSeat = selectedSeats.stream().filter(e -> seatBookingInMemoryCache.containsKey(e.getSeatNumber()))
				.count();
		if (lockedSeat == 0) {
			return true;
		}
		return false;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void CancelBooking(String screenid, String showid, List<Seat> selectedSeats) {

		// Update the inmemory Cache, Remove Locked Seat

		selectedSeats.stream().map(e -> seatBookingInMemoryCache.remove(e.getSeatNumber())).close();

		// Update User Seat Table , Status Available.
		List<SeatLockEntity> seatLokedList = new ArrayList<>();
		// populate Seat Those We have to Locked.
		seatLockerRepo.deleteAll(seatLokedList);

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void confirmSeat(String screenid, String showid, List<Seat> selectedSeats) {

		// Update the Seat with the Status COnfirmed.

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void releaseSeatLock(String screenid, String showid, List<Seat> selectedSeats) {
		// Remove from Cache map
		selectedSeats.forEach(st -> {
			seatBookingInMemoryCache.remove(st.getSeatNumber());
		});

		seatLockerRepo.deleteAll(new ArrayList<>());

	}

}
