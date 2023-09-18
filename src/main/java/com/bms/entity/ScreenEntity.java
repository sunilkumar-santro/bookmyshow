package com.bms.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "screen")
public class ScreenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long screenID;

	@Column
	public long screenSeats;

	@ManyToOne
	@JoinColumn(name = "theaterID", nullable = false)
	private TheatreEntity theatreEntity;

	@OneToMany(mappedBy = "screenEntity", cascade = CascadeType.ALL)
	private Set<SeatEntity> seats;

	public long getScreenID() {
		return screenID;
	}

	public void setScreenID(long screenID) {
		this.screenID = screenID;
	}

	public long getScreenSeats() {
		return screenSeats;
	}

	public void setScreenSeats(long screenSeats) {
		this.screenSeats = screenSeats;
	}

	public TheatreEntity getTheatreEntity() {
		return theatreEntity;
	}

	public void setTheatreEntity(TheatreEntity theatreEntity) {
		this.theatreEntity = theatreEntity;
	}

	public Set<SeatEntity> getSeats() {
		return seats;
	}

	public void setSeats(Set<SeatEntity> seats) {
		this.seats = seats;
	}

}
