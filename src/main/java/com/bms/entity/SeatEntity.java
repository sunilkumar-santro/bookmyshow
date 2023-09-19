package com.bms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "Seat")
public class SeatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatID;

	@Column
	private String seatRow;

	@Column
	private String seatNumber;

	@Column
	private String seatType;
	
    @Version
    private Long version;

	@ManyToOne
	@JoinColumn(name = "screenID", nullable = false)
	private ScreenEntity screenEntity;

	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public String getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public ScreenEntity getScreenEntity() {
		return screenEntity;
	}

	public void setScreenEntity(ScreenEntity screenEntity) {
		this.screenEntity = screenEntity;
	}

}
