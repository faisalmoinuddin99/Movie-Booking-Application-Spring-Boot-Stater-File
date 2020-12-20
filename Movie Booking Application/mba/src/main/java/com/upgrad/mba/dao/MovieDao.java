package com.upgrad.mba.dao;

import com.upgrad.mba.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/*
* By doing this, you will have all the basic CRUD operations for the Movie entity
* C  -> save(entity), saveAll(entities)
* R -> findById(id), findAll(), findAllById(ids), findAll(pageable)
* U -> save(entity), saveAll(entities)
* D -> delete(entity), deleteById(id), deleteAll(), deleteAll(entities)
* */
public interface MovieDao extends JpaRepository<Movie, Integer> {


    // Custom Query Method using Spring data JPA
    public List<Movie> findByMovieName(String movieName);
    public List<Movie> findByMovieNameAndDuration(String movieName, int duration);
    public List<Movie> findByReleaseDateBetween(LocalDateTime start, LocalDateTime end);
    public List<Movie> findByDurationGreaterThanEqual(int duration);
    public List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);
    public List<Movie> findByMovieNameContaining(String movieName);
    public List<Movie> findByMovieNameIgnoreCase(String movieName);

}
