package com.bms.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entity.SeatLockEntity;

@Repository
public interface SeatLockerRepo extends JpaRepository<SeatLockEntity, Long>{

}
