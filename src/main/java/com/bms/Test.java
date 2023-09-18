package com.bms;

import java.util.ArrayList;
import java.util.List;

import com.bms.dto.Screen;
import com.bms.dto.Seat;
import com.bms.dto.Theatre;
import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {

		Theatre theatre = new Theatre();
		theatre.setCity("HYD");
		theatre.setTheaterName("PVR");
		theatre.setScreens(new ArrayList<>());
		
		Screen screen = new Screen();
		screen.setTotalSeats(50);
		theatre.getScreens().add(screen );
		
		List<Seat> seats = new ArrayList();
		Seat seat = new Seat();
		seat.setSeatNumber("R1");
		seat.setSeatNumber("1");
		seat.setSeatType("SILVER");
		seats.add(seat);
		screen.setSeats(seats);
		 System.out.println(new Gson().toJson(screen));    
	}

}
