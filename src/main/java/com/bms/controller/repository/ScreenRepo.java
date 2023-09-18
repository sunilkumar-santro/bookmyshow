package com.bms.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entity.ScreenEntity;

@Repository
public interface ScreenRepo extends JpaRepository<ScreenEntity, Long> {

}
