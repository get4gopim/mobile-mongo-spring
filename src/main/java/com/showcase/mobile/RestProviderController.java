package com.showcase.mobile;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.domain.MovieList;
import com.showcase.service.MovieService;

@Controller
public class RestProviderController {

	private static final Logger logger = LoggerFactory.getLogger(RestProviderController.class);

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody MovieList getMovies() {
		logger.debug("Provider has received request to get all movies");

		// Call service here
		MovieList result = new MovieList();
		result.setData(movieService.findAllMovies());
		logger.debug("return the results");
		return result;
	}
	
    @RequestMapping(value = "/movies/searchBy/{id}", method = RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody Movie getMovieById(@PathVariable("id") BigInteger id) {
		logger.debug("Provider has received request to get movies with id: " + id);
		
		// Call service here
		return movieService.getMovieById(id);
	}
    
    @RequestMapping(value = "/movies/searchBy/{searchBy}/{value}", method = RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody MovieList findByAttrbutes(@PathVariable("searchBy") String searchBy, @PathVariable("value") String value) {
		logger.debug("Provider has received request to findByAttrbutes with searchBy :" + searchBy + " and value: " + value);
		
		// Call service here
		MovieList result = new MovieList();
		
		if (searchBy != null && searchBy.equalsIgnoreCase("music")) {
			result.setData(movieService.findByMusicDirectorLike(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("director")) {
			result.setData(movieService.findByFlimDirectorLike(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("title")) {
			result.setData(movieService.findByTitleLike(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("actor")) {
			result.setData(movieService.findByActorNameLike(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("actress")) {
			result.setData(movieService.findByActressNameLike(value));
		} /*else {
			result.setData(movieService.findAllMovies());
		}*/
		
		logger.debug("return the results");
		return result;
	}
    
    @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.DELETE)
    public String deleteMovieById(@PathVariable("id") BigInteger id) {
    	logger.debug("Provider has received request to get movies with deleteMovieById :" + id);
    	
    	movieService.deleteMovie(id);
    	
    	logger.debug("return the results");
        return "redirect:/owners/" + id;
    }
    
    @RequestMapping(value = "/movies/add/{id}", method = RequestMethod.PUT, headers="Accept=application/xml, application/json")
    public @ResponseBody Movie addMovie(@PathVariable("id") BigInteger id) {
    	logger.debug("Provider has received request to get movies with addMovie :" + id);
    	
    	//movieService.addMovie(movie);
    	
    	logger.debug("return the results");
    	return movieService.getMovieById(id);
    }

}
