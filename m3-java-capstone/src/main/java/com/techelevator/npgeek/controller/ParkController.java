package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.JdbcParkDao;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.JdbcWeatherDao;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;

@Controller
@SessionAttributes("celsius")
public class ParkController {
	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping("/homepage")
	public String displayHomePage(HttpServletRequest request) {
		request.setAttribute("parks", parkDao.getAllParks());
		return "homepage";
	}
	
	@RequestMapping("/parkDetail")
	public String displayPark(HttpServletRequest request, ModelMap map) {
		if (! map.containsAttribute("celsius")) {
			map.addAttribute("celsius", "false");
		}
		String parkCode = request.getParameter("parkCode").toUpperCase();
		List <Weather> stuff = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		request.setAttribute("weathers", weatherDao.getWeatherByParkCode(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	public String displayParkAndWeathers(HttpServletRequest request, ModelMap map) {
		String parkCode = request.getParameter("parkCode").toUpperCase();
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		List <Weather> stuff = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("weathers", weatherDao.getWeatherByParkCode(parkCode));
		map.addAttribute("celsius", request.getParameter("celsius"));
		return "parkDetail";
	}
	
	
}
