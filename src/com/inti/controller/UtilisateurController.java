package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@CrossOrigin("*")
@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll(Utilisateur.class);
	}
	
	@RequestMapping(value="users", method = RequestMethod.POST)
	public void saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return;
	}
	
	@RequestMapping(value="users/{idUtilisateur}", method= RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur,@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(Utilisateur.class, idUtilisateur);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(utilisateur.getPassword());
		currentUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
		currentUtilisateur.setListRole(utilisateur.getListRole());
		//return utilisateurService.save(currentUtilisateur);
		return currentUtilisateur;
	}
	
	@RequestMapping(value="users/{idUtilisateur}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("idUtilisateur")Long idUtilisateur) {
		return utilisateurService.findOne(Utilisateur.class, idUtilisateur);
	}

}
