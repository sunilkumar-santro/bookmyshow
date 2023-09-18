package com.bms.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Theatre")
public class TheatreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theaterID;

	@Column
	private String cityName;

	@Column
	private String theaterName;

	@OneToMany(mappedBy="theatreEntity", cascade = CascadeType.ALL)
	private Set<ScreenEntity> screens;


	public Long getTheaterID() {
		return theaterID;
	}

	public void setTheaterID(Long theaterID) {
		this.theaterID = theaterID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Set<ScreenEntity> getScreens() {
		return screens;
	}

	public void setScreens(Set<ScreenEntity> screens) {
		this.screens = screens;
	}

}
