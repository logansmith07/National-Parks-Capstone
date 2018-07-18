package com.techelevator.npgeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.JdbcParkDao;

@Controller

public class SurveyController {
	@Autowired
	private JdbcSurveyDao surveyDao;
	
	@Autowired
	private JdbcParkDao parkDao;
	
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
			RedirectAttributes attr
	) {
		
		attr.addFlashAttribute("survey", survey);
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		surveyDao.add(survey);
		//bs from here
		surveyDao.gettheresults;
		
		parkDao.getAllParks();
		
		return "redirect:/surveyResults";
	}

}



