package com.upgrad.mba;

import com.upgrad.mba.dao.CityDao;
import com.upgrad.mba.entites.City;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication // Responsible for all the auto configuration
public class MovieBookingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext _context =  SpringApplication.run(MovieBookingApplication.class, args);
		DataSource source = _context.getBean(DataSource.class);


		// Saving inside the City table
		CityDao cityDao = _context.getBean(CityDao.class);
		City city = new City();
		city.setCityName("Mumbai");

		System.out.println( cityDao.save(city)); // return the id
	}

}
