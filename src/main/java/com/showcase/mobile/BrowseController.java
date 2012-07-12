/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.showcase.mobile;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.mobile.device.site.SitePreferenceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UrlPathHelper;

import com.showcase.mongo.domain.Feedback;
import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.repository.MovieRepository;
import com.showcase.service.MovieService;

/**
 * Handles requests for the showcase application.
 * @author Keith Donald
 */
@Controller
public class BrowseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BrowseController.class);
	
	@Autowired
	private MovieService movieService;

	/**
	 * Show the home page to the user. 
	 * Declares a {@link SitePreference} parameter to show how you can resolve the user's site preference.
	 * This controller renders a different version of the home view if the user has a mobile site preference.
	 */
	@RequestMapping("/browse")
	public ModelAndView browse(HttpServletRequest servletRequest) {
		logger.info("browse ...");
		ModelAndView mav = new ModelAndView();
		
		//movieService.insertDataFirstTime();
		
		String searchBy = servletRequest.getParameter("searchBy");
		if (searchBy != null && searchBy.equalsIgnoreCase("music")) {
			String musicDirector = servletRequest.getParameter("value");
			mav.addObject("listMovies", movieService.findByMusicDirector(musicDirector));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("director")) {
			String flimDirector = servletRequest.getParameter("value");
			mav.addObject("listMovies", movieService.findByFlimDirector(flimDirector));
		} else {
			mav.addObject("listMovies", movieService.findAllMovies());
		}
		mav.setViewName("browse");
		
		return mav;
	}
	
	@RequestMapping("/addmovie")
	public ModelAndView addmovie(HttpServletRequest servletRequest) {
		logger.info("addmovie ...");
		ModelAndView mav = new ModelAndView();
		
		String action = servletRequest.getParameter("btnAddMovie");
		logger.info("action = " + action);
		
		
		String title = servletRequest.getParameter("title");
		String actorName = servletRequest.getParameter("actor");
		String actressName = servletRequest.getParameter("actress");
		String musicDirector = servletRequest.getParameter("music");
		String flimDirector = servletRequest.getParameter("director");
		String imageUrl = servletRequest.getParameter("imageUrl");
		
		Movie movie = new Movie(title, "BluRay", true, actorName, actressName, musicDirector, flimDirector, imageUrl);
		
		if (action.equalsIgnoreCase("Add Movie")) {
			movieService.addMovie(movie);
		} else if (action.equalsIgnoreCase("Update Movie")) {
			BigInteger id = new BigInteger( servletRequest.getParameter("id") );
			logger.info("id = " + id);
			
			movieService.updateMovie(movie, id);
		}
		
		
		logger.info("addmovie sucess ... redirect to browse... ");
		mav.setView(new RedirectView("browse.htm"));
		return mav;
	}
	
	@RequestMapping("/deletemovie")
	public ModelAndView deletemovie(HttpServletRequest servletRequest) {
		logger.info("deletemovie ...");
		ModelAndView mav = new ModelAndView();
		
		BigInteger id = new BigInteger( servletRequest.getParameter("id") );
		logger.info("id = " + id);
		movieService.deleteMovie(id);
		
		logger.info("deletemovie sucess ... redirect to browse... ");
		mav.setView(new RedirectView("browse.htm"));
		return mav;
	}
	
	@RequestMapping("/editmovie")
	public ModelAndView editmovie(HttpServletRequest servletRequest) {
		logger.info("editmovie ...");
		ModelAndView mav = new ModelAndView();
		
		BigInteger id = new BigInteger( servletRequest.getParameter("id") );
		logger.info("id = " + id);
		Movie movie = movieService.getMovieById(id);
		mav.addObject("movie", movie);
		
		logger.info("editmovie sucess ... redirect to browse... ");
		//mav.setView(new RedirectView("browse.htm"));
		mav.setViewName("addmovie");
		return mav;
	}
	
	
	@RequestMapping("/savefeed")
	public ModelAndView savefeed(HttpServletRequest servletRequest) {
		logger.info("savefeed ...");
		ModelAndView mav = new ModelAndView();
		
		String username = servletRequest.getParameter("username");
		String email = servletRequest.getParameter("email");
		String comments = servletRequest.getParameter("comments");
		
		Feedback feed = new Feedback(username, email, comments);
		
		movieService.saveFeed(feed);
		
		logger.info("savefeed sucess ... redirect to browse... ");
		mav.setView(new RedirectView("viewfeeds.htm"));
		return mav;
	}
	
	@RequestMapping("/viewfeeds")
	public ModelAndView viewfeeds(HttpServletRequest servletRequest) {
		logger.info("viewfeeds ...");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listFeeds", movieService.findAllFeeds());
		
		mav.setViewName("viewfeeds");
		
		return mav;
	}
	
	@RequestMapping("/deletefeed")
	public ModelAndView deletefeed(HttpServletRequest servletRequest) {
		logger.info("deletefeed ...");
		ModelAndView mav = new ModelAndView();
		
		BigInteger id = new BigInteger( servletRequest.getParameter("id") );
		logger.info("id = " + id);
		movieService.deleteFeedback(id);
		
		logger.info("deletefeed sucess ... redirect to viewfeeds... ");
		mav.setView(new RedirectView("viewfeeds.htm"));
		return mav;
	}

}