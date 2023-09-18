package com.bms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.ScreenShows;
import com.bms.dto.ShowScreens;

@RestController
@RequestMapping("/showservice")
public class ShowController {

	// This method is used to create multiple shows on Single Screen
	@PostMapping("/screenshows")
	public boolean createShowsforScreen(@RequestBody ScreenShows screenShows) {
		return true;
	}

	// This method is used to create single shows on multiple Screen
	@PostMapping("/showscreens")
	public boolean createChowsforScreen(@RequestBody ShowScreens showScreens) {
		return true;
	}
	


}
