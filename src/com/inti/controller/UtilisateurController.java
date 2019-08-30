package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@CrossOrigin("*")
@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ModelAndView findAllUtilisateur() {
		ModelAndView model = new ModelAndView("users");
		List<Utilisateur> listUtilisateur = utilisateurService.findAll(Utilisateur.class);
		model.addObject("listUtilisateur", listUtilisateur);
		return model;
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public ModelAndView saveUtilisateur(@ModelAttribute("u") Utilisateur utilisateur) {
		utilisateurService.save(utilisateur);
		return new ModelAndView("redirect:/users");
	}

}
