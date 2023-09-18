package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.Screen;
import com.bms.dto.Theatre;
import com.bms.dto.Theatres;
import com.bms.service.TheaterService;

@RestController
@RequestMapping("/bookmyshow")
public class TheaterController {

	@Autowired
	TheaterService theaterService;

	@PostMapping("/theaters")
	public Theatre createTheater(@RequestBody Theatre theatreCity) {

		return theaterService.createTheater(theatreCity);
	}

	@GetMapping("/theaters/{cityName}")
	public Theatres getTheater(@PathVariable String cityName) {
		return theaterService.findTheater(cityName);
	}

	@PutMapping("/theaters/screen/{screenID}")
	public Screen updateScreen(@RequestBody Screen screen, @PathVariable(name = "screenID") Long screenID) {
		return theaterService.updateScreen(screen, screenID);
	}

}
