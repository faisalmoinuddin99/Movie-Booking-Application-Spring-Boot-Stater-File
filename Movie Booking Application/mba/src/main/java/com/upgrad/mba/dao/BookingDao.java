package com.upgrad.mba.dao;

import com.upgrad.mba.entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
