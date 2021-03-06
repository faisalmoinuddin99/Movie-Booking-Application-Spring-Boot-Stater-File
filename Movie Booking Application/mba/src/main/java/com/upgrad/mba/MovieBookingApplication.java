package com.upgrad.mba;

import com.upgrad.mba.dao.CityDao;
import com.upgrad.mba.dao.MovieDao;
import com.upgrad.mba.dao.TheatreDao;
import com.upgrad.mba.entites.City;
import com.upgrad.mba.entites.Movie;
import com.upgrad.mba.entites.Theatre;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication // Responsible for all the auto configuration
public class MovieBookingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext _context =  SpringApplication.run(MovieBookingApplication.class, args);
		DataSource source = _context.getBean(DataSource.class);

		//  [ Concept of Spring Data Jpa Repository ]
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

		//System.out.println(movieDao.save(movie1));

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

		// Movie 4

		Movie movie4 = new Movie();
		movie4.setMovieName("Joker");
		movie4.setMovieDescription("Arthur Fleck, a party clown, leads an impoverished life with his ailing mother. However, when society shuns him and brands him as a freak, he decides to embrace the life of crime and chaos.");
		movie4.setReleaseDate(LocalDateTime.of(2019,10,2,2,2));
		movie4.setDuration(110);
		movie4.setCoverPhotoUrl("cover-photo-url");
		movie4.setTrailerUrl("trailer-url");

		// Movie 5

		Movie movie5 = new Movie();
		movie5.setMovieName("The Dark Knight");
		movie5.setMovieDescription("After Gordon, Dent and Batman begin an assault on Gotham's organised crime, the mobs hire the Joker, a psychopathic criminal mastermind who offers to kill Batman and bring the city to its knees.");
		movie5.setReleaseDate(LocalDateTime.of(2008,7,18,2,32));
		movie5.setDuration(150);
		movie5.setCoverPhotoUrl("cover-photo-url");
		movie5.setTrailerUrl("trailer-url");

		List<Movie> movieList = new ArrayList<>() ;
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);

		movieDao.saveAll(movieList);

		// ##################### Page Request ############################

		System.out.println("***************Finding all movies *********************");
		movieDao.findAll().forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("***************Finding first page of movie *********************");
		Page<Movie> page0 = movieDao.findAll(PageRequest.of(0,2));
		page0.stream().forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("***************Finding second page of movie *********************");
		Page<Movie> page1 = movieDao.findAll(PageRequest.of(1,2));
		page1.stream().forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("***************Finding first page of movie based on ascending duration  *********************");
		Page<Movie> page0Sorted = movieDao.findAll(PageRequest.of(0,2, Sort.by("duration").ascending()));
		page0Sorted.stream().forEach(movie -> System.out.println(movie.getMovieName()));


		System.out.println("**** find by movie name *****");
		movieDao.findByMovieName("Tenet")
				.forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("**** find by movieName and Duration ****");
		movieDao.findByMovieNameAndDuration("The Dark Knight", 150)
				.forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("***** find by release date between");
		movieDao.findByReleaseDateBetween(
				LocalDateTime.of(2019,3,1,0,0),
				LocalDateTime.of(2020,3,1,0,0))
				.forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("**** find by duration greater than or equal ****");
		movieDao.findByDurationGreaterThanEqual(120)
				.forEach(movie -> System.out.println(movie.getMovieName()));

		System.out.println("*** find by release date after ****");
		movieDao.findByReleaseDateAfter(LocalDateTime.of(2019,3,1,0,0))
				.forEach(movie -> System.out.println(movie.getMovieName()));

		// Saving inside the City table [ Concept of Spring ORM ]
//		CityDao cityDao = _context.getBean(CityDao.class);
//		City city = new City();
//		city.setCityName("Mumbai");
//
//		System.out.println( cityDao.save(city)); // return the id

		// ************************* Theatre Name **********************************
		TheatreDao theatreDao = _context.getBean(TheatreDao.class);

		Theatre theatre1 = new Theatre();
		theatre1.setTheatreName("PVR");
		theatre1.setTicketPrice(540);

		Theatre theatre2 = new Theatre();
		theatre2.setTheatreName("INOX");
		theatre2.setTicketPrice(500);

		Theatre theatre3 = new Theatre();
		theatre3.setTheatreName("Cinepolis Multiplex");
		theatre3.setTicketPrice(850);

		List<Theatre> theatreList = new ArrayList<>() ;
		theatreList.add(theatre1);
		theatreList.add(theatre2);
		theatreList.add(theatre3);


		theatreDao.saveAll(theatreList);

		System.out.println("***  Find By Theatre Name ***");
		theatreDao.findByTheatreName("PVR")
				.forEach(theatre -> System.out.println(theatre.getTheatreName()));
		System.out.println("\n");
		System.out.println("*** Find By Ticket Price Less Than ***");
		theatreDao.findByTicketPriceLessThan(600)
				.forEach(theatre -> System.out.println(theatre.getTicketPrice()));
		System.out.println("\n");
		System.out.println("*** Find By Theatre Name Containing ***");
		theatreDao.findByTheatreNameContaining("Cinepolis Multiplex")
				.forEach(theatre -> System.out.println(theatre.getTheatreName()));
	}

}
