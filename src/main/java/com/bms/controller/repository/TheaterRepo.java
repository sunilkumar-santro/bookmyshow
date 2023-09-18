package com.bms.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entity.TheatreEntity;

@Repository
public interface TheaterRepo  extends JpaRepository<TheatreEntity, Long> {

	List<TheatreEntity> findByCityName(String cityName);
	

	
}
