package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;

@CrossOrigin("*")
@RestController
public class TacheController {
	
	@Autowired
	ITacheService tacheService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveTache(@ModelAttribute("t") Tache tache) {
		tacheService.save(tache);
		return new ModelAndView("redirect:/tasks");
	}

}
