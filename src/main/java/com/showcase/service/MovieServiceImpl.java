package com.showcase.service;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.showcase.mobile.BrowseController;
import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.repository.MovieRepository;

@Component
public class MovieServiceImpl implements MovieService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public void insertDataFirstTime() {
		logger.info("insertDataFirstTime ...");
		
		if (mongoOperations.collectionExists(Movie.class)) {
			mongoOperations.dropCollection(Movie.class);
			mongoOperations.createCollection(Movie.class);
		}		

		Movie m1 = new Movie("Endhiran", "BluRay", true, "Rajinikanth", "Aishwarya Rai", "AR Rahman", "Shankar");
		Movie m2 = new Movie("Ayyan", "BluRay", true, "Surya", "Aishwarya Rai", "Harris Jayaraj", "Sun");
		Movie m3 = new Movie("Roja", "BluRay", true, "Rajinikanth", "Aishwarya Rai", "AR Rahman", "Manirathnam");
		Movie m4 = new Movie("Nanban", "BluRay", true, "Vijay", "Illena", "Harris Jayaraj", "Shankar");
		Movie m5 = new Movie("Bombay", "BluRay", true, "Aravindsamy", "Manisha", "AR Rahman", "Manirathnam");
		Movie m6 = new Movie("Ayya", "DVD", true, "Sarathkumar", null, "", null);

		movieRepository.save(m1);
		movieRepository.save(m2);
		movieRepository.save(m3);
		movieRepository.save(m4);
		movieRepository.save(m5);
		movieRepository.save(m6);
		
		logger.info("insertDataFirstTime finished");
	}
	
	public List<Movie> findAllMovies() {
		logger.info("findAllMovies ...");
		List<Movie> results = (List<Movie>) movieRepository.findAll();
		logger.info("results = " + results);
		return results;
	}
	
	public List<Movie> findByMusicDirector(String musicDirector) {
		logger.info("findAllMovies ...");
		List<Movie> results = (List<Movie>) movieRepository.findByMusicDirector(musicDirector);
		logger.info("results = " + results);
		return results;
	}
	
	public List<Movie> findByFlimDirector(String flimDirector) {
		logger.info("findByMusicDirector ...");
		List<Movie> results = (List<Movie>) movieRepository.findByFlimDirector(flimDirector);
		logger.info("results = " + results);
		return results;
	}
	
	public void addMovie(Movie movie) {
		logger.info("addMovie ... = " + movie);
		movieRepository.save(movie);
		logger.info("addMovie finished");
	}
	
	public void deleteMovie(BigInteger id) {
		logger.info("deleteMovie ... = " + id);
		Movie movie = movieRepository.findOne(id);
		movieRepository.delete(movie);
		logger.info("deleteMovie finished");
	}
	
	public Movie getMovieById(BigInteger id) {
		logger.info("getMovieById ... = " + id);
		Movie movie = movieRepository.findOne(id);
		logger.info("getMovieById finished");
		return movie;
	}
	
	public void updateMovie(Movie movie, BigInteger id) {
		logger.info("updateMovie ... = " + id);
		Movie m = movieRepository.findOne(id);
		m.setTitle(movie.getTitle());
		m.setActorName(movie.getActorName());
		m.setActressName(movie.getActressName());
		m.setMusicDirector(movie.getMusicDirector());
		m.setFlimDirector(movie.getFlimDirector());
		movieRepository.save(m);
		logger.info("updateMovie finished");
	}
}
