package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@CrossOrigin("*")
@RestController
public class AffaireController {

	@Autowired
	IAffaireService affaireService;

	@RequestMapping(value = "cases", method = RequestMethod.GET)
	public List<Affaire> findAll() {
		return affaireService.findAll(Affaire.class);
	}
	
	@RequestMapping(value="cases", method = RequestMethod.POST)
	public void saveAffaire(@RequestBody Affaire affaire) {
		return;
	}
	
	@RequestMapping(value="cases/{idAffaire}", method = RequestMethod.GET)
	public Affaire findOne(@PathVariable("idAffaire")Long idAffaire) {
		return affaireService.findOne(Affaire.class, idAffaire);
	}

}
