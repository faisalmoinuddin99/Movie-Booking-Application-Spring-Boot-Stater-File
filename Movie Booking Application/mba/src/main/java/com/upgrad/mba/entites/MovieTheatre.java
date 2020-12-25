package com.upgrad.mba.entites;

import javax.persistence.*;

@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieTheatreId ;

    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie ;

    @ManyToOne
    @JoinColumn(name = "theatreId", nullable = false)
    private Theatre theatre;

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
