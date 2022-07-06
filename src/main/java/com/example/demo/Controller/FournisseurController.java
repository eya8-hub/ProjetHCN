package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fournisseur;
import com.example.demo.repository.FournisseurRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	  FournisseurRepository fournisseurRepository;
	
	//////// create fournisseur 
	 @PostMapping("/create")
	  public ResponseEntity<Fournisseur> createTutorial(@RequestBody Fournisseur fournisseur) {
	    try {
	      Fournisseur _fournisseur = fournisseurRepository.save(new Fournisseur(fournisseur.getId(),fournisseur.getFabriquant(),fournisseur.getJurant(),fournisseur.getAdresse(),fournisseur.getMatricule_fiscale(),fournisseur.getTelephone(),fournisseur.getFax(),fournisseur.getVisAvis()));
	      return new ResponseEntity<>(_fournisseur, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 //////////////afficher fournisseurs
	 @GetMapping("/fournisseurs")
	  public ResponseEntity<List<Fournisseur>> getAllFournisseurs(@RequestParam(required = false) String fabriquant) {
	    try {
	      List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
	      if (fabriquant == null)
	    	  fournisseurRepository.findAll().forEach(fournisseurs::add);
	      else
	        fournisseurRepository.findByFabriquantContaining(fabriquant).forEach(fournisseurs::add);
	      if (fournisseurs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 /////////////
}
