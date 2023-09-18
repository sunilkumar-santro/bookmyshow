package com.bms.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.controller.repository.ScreenRepo;
import com.bms.controller.repository.TheaterRepo;
import com.bms.dto.Screen;
import com.bms.dto.Seat;
import com.bms.dto.Theatre;
import com.bms.dto.Theatres;
import com.bms.entity.ScreenEntity;
import com.bms.entity.SeatEntity;
import com.bms.entity.TheatreEntity;

import jakarta.transaction.Transactional;
import util.ObjectMapper;

@Service
public class TheaterService {

	@Autowired
	TheaterRepo theaterRepo;

	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public Theatre createTheater(Theatre theatre) {

		TheatreEntity theaterEntity = new TheatreEntity();
		theaterEntity.setCityName(theatre.getCity());
		theaterEntity.setTheaterName(theatre.getTheaterName());
		if (theatre.getScreens() != null) {
			HashSet<ScreenEntity> screenEntitySet = new HashSet<ScreenEntity>();
			for (Screen screen : theatre.getScreens()) {
				ScreenEntity screenEntity = new ScreenEntity();
				screenEntity.setScreenSeats(screen.getTotalSeats());
				screenEntity.setTheatreEntity(theaterEntity);
				screenEntitySet.add(screenEntity);

			}

			theaterEntity.setScreens(screenEntitySet);
		}

		theaterEntity = theaterRepo.save(theaterEntity);
		// convert to the DTO and return
		return ObjectMapper.mapTheatreEntityToDTO(theaterEntity);
	}

	public Theatres findTheater(String cityName) {

		List<TheatreEntity> theaterEntityList = theaterRepo.findByCityName(cityName);
		// convery to theater City and return

		return ObjectMapper.mapTheatreEntityToDTO(theaterEntityList);
	}

	public Screen updateScreen(Screen screen, Long screenID) {
		Optional<ScreenEntity> screenEntity = screenRepo.findById(screenID);

		if (screenEntity.isPresent()) {
			ScreenEntity sentity = screenEntity.get();
			List<Seat> seats = screen.getSeats();

			Set<SeatEntity> screenEntitySet = seats.stream().map(e -> modelMapper.map(e, SeatEntity.class))
					.collect(Collectors.toSet());
			screenEntitySet.forEach(e -> e.setScreenEntity(sentity));
			screenEntitySet.addAll(sentity.getSeats());
			sentity.setSeats(screenEntitySet);
			screenRepo.save(sentity);

		} else {

			System.out.println("Seat is null");
		}

		Optional<ScreenEntity> updatedscreenEntity = screenRepo.findById(screenID);
		List<Seat> fetchedSeats = updatedscreenEntity.get().getSeats().stream().map(e -> modelMapper.map(e, Seat.class))
				.collect(Collectors.toList());
		screen.setSeats(fetchedSeats);
		screen.setScreenid(updatedscreenEntity.get().getScreenID());
		screen.setTotalSeats(updatedscreenEntity.get().getScreenSeats());
		return screen;
	}

}
