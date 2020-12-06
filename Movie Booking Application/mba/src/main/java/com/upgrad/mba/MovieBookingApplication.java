package com.upgrad.mba;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication // Responsible for all the auto configuration
public class MovieBookingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext _context =  SpringApplication.run(MovieBookingApplication.class, args);
		DataSource soruce = _context.getBean(DataSource.class);
	}

}
