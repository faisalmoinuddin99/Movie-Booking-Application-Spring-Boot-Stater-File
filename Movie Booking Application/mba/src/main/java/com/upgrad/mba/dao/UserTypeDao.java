package com.upgrad.mba.dao;

import com.upgrad.mba.entites.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {
}
