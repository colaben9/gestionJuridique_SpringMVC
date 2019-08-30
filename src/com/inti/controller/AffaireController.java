package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@CrossOrigin("*")
@RestController
public class AffaireController {

	@Autowired
	IAffaireService affaireService;

	@RequestMapping(value = "cases", method = RequestMethod.GET)
	public ModelAndView findAllAffaire() {
		ModelAndView model = new ModelAndView("cases");
		List<Affaire> listAffaire = affaireService.findAll(Affaire.class);
		model.addObject("listAffaire", listAffaire);
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveAffaire(@ModelAttribute("a") Affaire affaire) {
		affaireService.save(affaire);
		return new ModelAndView("redirect:/cases");
	}

}
