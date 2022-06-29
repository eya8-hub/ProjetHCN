package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Inventaire;


import com.example.demo.repository.IventaireRepository;
import com.example.demo.repository.UtilisationRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/inventaire")
public class InventaireController {
	
	 @Autowired
	  IventaireRepository inventaireRepository;
	  UtilisationRepository utilisationRepository;
	 ////////////// ajouter Inventaire
	 @PostMapping("/create")
	  public ResponseEntity<Inventaire> createTutorial(@RequestBody Inventaire inventaire) {
	    try {
	      Inventaire _inventaire = inventaireRepository.save(new Inventaire(inventaire.getId(),inventaire.getReference(),inventaire.getType(),inventaire.getMarque(),inventaire.getNumSerie(),inventaire.getDateAquis(),inventaire.getDateMEP(),inventaire.getDateFinAquis(),inventaire.getAccessoire(),inventaire.getUtilisation()));
	      return new ResponseEntity<>(_inventaire, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 ////////////afficher inventaires
	 @GetMapping("/inventaires")
	  public ResponseEntity<List<Inventaire>> getAllInventaires(@RequestParam(required = false) String reference) {
	    try {
	      List<Inventaire> inventaires = new ArrayList<Inventaire>();
	      if (reference == null)
	        inventaireRepository.findAll().forEach(inventaires::add);
	      else
	        inventaireRepository.findByReferenceContaining(reference).forEach(inventaires::add);
	      if (inventaires.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(inventaires, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
//	 ///////////modifier inventaire
	 @PutMapping("/modifier/{id}")
	  public ResponseEntity<Inventaire> updateInventaire(@PathVariable("id") String id, @RequestBody Inventaire inventaire) {
	    Optional<Inventaire> inventaireData = inventaireRepository.findById(id);
	    if (inventaireData.isPresent()) {
	      Inventaire _inventaire = inventaireData.get();
	      _inventaire.setReference(inventaire.getReference());
	      _inventaire.setAccessoire(inventaire.getAccessoire());
	      _inventaire.setDateAquis(inventaire.getDateAquis());
	      _inventaire.setDateFinAquis(inventaire.getDateFinAquis());
	      _inventaire.setDateMEP(inventaire.getDateMEP());
	      _inventaire.setMarque(inventaire.getMarque());
	      _inventaire.setNumSerie(inventaire.getNumSerie());
	      _inventaire.setUtilisation(inventaire.getUtilisation());
	      
	      return new ResponseEntity<>(inventaireRepository.save(_inventaire), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 
//	//////////////////// supprimer inventaire 
	 @DeleteMapping("/supprimer/{id}")
	  public ResponseEntity<HttpStatus> deleteInventaire(@PathVariable("id") String reference) {
	    try {
	      inventaireRepository.deleteById(reference);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
