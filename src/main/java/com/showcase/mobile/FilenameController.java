/*
 * Copyright 2012 the original author or authors.
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
import org.springframework.web.util.UrlPathHelper;

import com.showcase.service.MovieService;

/**
 * Handles requests for the About page.
 * @author Roy Clarkson
 */
@Controller
public class FilenameController {
	
	private static final Logger logger = LoggerFactory.getLogger(FilenameController.class);

	@Autowired
	private MovieService movieService;
	
	/**
	 * Show the About page to the user.
	 * Declares a {@link SitePreference} parameter to show how you can resolve the user's site preference.
	 * This controller renders a different version of the home view if the user has a mobile site preference.
	 */
	@RequestMapping("/filename")
	public ModelAndView filename(HttpServletRequest servletRequest) {
		logger.info("filename ...");
		
		ModelAndView mav = new ModelAndView();
		String path = servletRequest.getParameter("path");
		logger.info("filename?path = " + path);
		
		movieService.getFromCache("9952013448");
		
		/*Device currentDevice = DeviceUtils.getCurrentDevice(servletRequest);
		mav.addObject("currentDevice", currentDevice.toString());*/
		
		if (path != null)
			mav.setViewName(path);
		else 
			mav.setViewName("index");
		
		return mav;
	}

}