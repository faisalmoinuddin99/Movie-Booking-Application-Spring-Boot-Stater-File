package com.upgrad.mba.dao;

import com.upgrad.mba.entites.City;

public interface CityDao {

    public City save(City city); // Create
    public City findById(int id); // Read
    public City update(City city); // Update
    public void delete(City city); // Delete
}
