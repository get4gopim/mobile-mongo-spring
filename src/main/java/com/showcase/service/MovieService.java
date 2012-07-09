package com.showcase.service;

import java.math.BigInteger;
import java.util.List;

import com.showcase.mongo.domain.Feedback;
import com.showcase.mongo.domain.Movie;

public interface MovieService {

	public void insertDataFirstTime();
	public List<Movie> findAllMovies();
	public void addMovie(Movie movie);
	public void deleteMovie(BigInteger id);
	public Movie getMovieById(BigInteger id);
	public void updateMovie(Movie movie, BigInteger id);
	public List<Movie> findByMusicDirector(String musicDirector);
	public List<Movie> findByFlimDirector(String flimDirector);
	
	public void saveFeed(Feedback feedback);
	public List<Feedback> findAllFeeds();
	public void deleteFeedback(BigInteger id);
	
}
