package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.Seat;
import com.bms.service.SeatServcie;

@RestController
@RequestMapping("/bookmyshow/seatservice")
public class SeatServcieController {

	@Autowired
	SeatServcie seatServcie;

	@GetMapping("/seats/{screenid}/{showid}")
	public List<Seat> getallSeats(@PathVariable(name = "screenid") String screenid,
			@PathVariable(name = "screenid") String showid) {
		return seatServcie.getAvilableSeat(screenid, showid);
	}

}
