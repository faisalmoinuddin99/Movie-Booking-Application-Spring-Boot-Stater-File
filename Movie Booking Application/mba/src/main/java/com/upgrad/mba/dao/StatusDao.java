package com.upgrad.mba.dao;

import com.upgrad.mba.entites.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
}
