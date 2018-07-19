package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.JdbcParkDao;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;

@Controller

public class SurveyController {
	
	@Autowired
	private SurveyDao surveyDao;
	
	@Autowired
	private ParkDao parkDao;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyForm(Model modelHolder) {
		if(! modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		}
		
		return "survey";
	}
	
	@RequestMapping(path="/survey/submit", method=RequestMethod.POST)
	public String handleSurveyForm(
			@Valid @ModelAttribute("survey") Survey survey, 
			BindingResult result,
			RedirectAttributes attr,
			HttpServletRequest request
	) {
		attr.addFlashAttribute("survey", survey);
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		surveyDao.addSurvey(survey);
		
		return "redirect:/surveyResults";
	}

	@RequestMapping("/surveyResults")
	public String showSurveyResults (HttpServletRequest request) {
		List<Park> parks = parkDao.getParksWithSurveyCount();
		request.setAttribute("parks", parks);
		return "surveyResults";
		
	}
	
}



