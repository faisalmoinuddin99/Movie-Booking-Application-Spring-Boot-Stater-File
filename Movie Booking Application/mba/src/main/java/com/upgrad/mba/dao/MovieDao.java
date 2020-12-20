package com.upgrad.mba.dao;

import com.upgrad.mba.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* By doing this, you will have all the basic CRUD operations for the Movie entity
* C  -> save(entity), saveAll(entities)
* R -> findById(id), findAll(), findAllById(ids), findAll(pageable)
* U -> save(entity), saveAll(entities)
* D -> delete(entity), deleteById(id), deleteAll(), deleteAll(entities)
* */
public interface MovieDao extends JpaRepository<Movie, Integer> {
}
