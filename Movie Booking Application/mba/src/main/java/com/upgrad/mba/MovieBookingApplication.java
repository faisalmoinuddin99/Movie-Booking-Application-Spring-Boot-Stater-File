package com.upgrad.mba;

import com.upgrad.mba.dao.CityDao;
import com.upgrad.mba.dao.MovieDao;
import com.upgrad.mba.entites.City;
import com.upgrad.mba.entites.Movie;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@SpringBootApplication // Responsible for all the auto configuration
public class MovieBookingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext _context =  SpringApplication.run(MovieBookingApplication.class, args);
		DataSource source = _context.getBean(DataSource.class);

		MovieDao movieDao = _context.getBean(MovieDao.class);


		// Movie 1
		Movie movie1 = new Movie();
		movie1.setMovieName("Avengers: Infinity War");
		movie1.setMovieDescription("The Avengers must stop Thanos, an intergalactic warlord. " +
				"from getting this hands on all the infinity stones.");
		movie1.setReleaseDate(LocalDateTime.of(2018,4,27,5,30));
		movie1.setDuration(150);
		movie1.setCoverPhotoUrl("cover-photo-url");
		movie1.setTrailerUrl("trailer-url");

		System.out.println(movieDao.save(movie1));

		// Movie 2
		Movie movie2 = new Movie();
		movie2.setMovieName("Chhalaang");
		movie2.setMovieDescription("Chhalaang is a 2020 Indian Hindi-language sports comedy drama film directed by Hansal Mehta. It is produced by Ajay Devgan, Luv Ranjan, Ankur Garg and presented by Bhushan Kumar. Chhalaang stars Rajkummar Rao, Nushrat Bharucha and Mohammed Zeeshan Ayyub. Principal photography commenced in last quarter of 2018.");
		movie2.setReleaseDate(LocalDateTime.of(2020,6,12,2,16));
		movie2.setDuration(120);
		movie2.setCoverPhotoUrl("cover-photo-url");
		movie2.setTrailerUrl("trailer-url");

		// movie 3

		Movie movie3 = new Movie();
		movie3.setMovieName("Tenet");
		movie3.setMovieDescription("A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.");
		movie3.setReleaseDate(LocalDateTime.of(2020,12,4,2,30));
		movie3.setDuration(140);
		movie3.setCoverPhotoUrl("cover-photo-url");
		movie3.setTrailerUrl("trailer-url");

		// Saving inside the City table
//		CityDao cityDao = _context.getBean(CityDao.class);
//		City city = new City();
//		city.setCityName("Mumbai");
//
//		System.out.println( cityDao.save(city)); // return the id
	}

}
