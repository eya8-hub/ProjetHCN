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
import com.example.demo.model.Utilisation;

import com.example.demo.repository.UtilisationRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/utilisation")
public class UtilisationController {
	 @Autowired
	  UtilisationRepository utilisationRepository;
	 
	 /////////// creer utilisation
	 @PostMapping("/create")
	  public ResponseEntity<Utilisation> createUtilisation(@RequestBody Utilisation utilisation) {
	    try {
	      Utilisation _utlisation = utilisationRepository.save(new Utilisation(utilisation.getId(),utilisation.getEmplacement(),utilisation.getUtilisation(),utilisation.getResponsable(),utilisation.getEmplacementDoc()));
	      return new ResponseEntity<>(_utlisation, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
///////////// afiicher tous les utilisations 
	 
	 @GetMapping("/utilisations")
	  public ResponseEntity<List<Utilisation>> getAllUtilisations(@RequestParam(required = false) String emplacement) {
	    try {
	      List<Utilisation> utilisations = new ArrayList<Utilisation>();
	      if (emplacement == null)
	        utilisationRepository.findAll().forEach(utilisations::add);
	      else
	        utilisationRepository.findByEmplacementContaining(emplacement).forEach(utilisations::add);
	      if (utilisations.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(utilisations, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 /////////////////////// modifier  utilisation
	
	  
	  @PutMapping("/utilisations/{id}")
	  public ResponseEntity<Utilisation> updateUtilisation(@PathVariable("id") String id, @RequestBody Utilisation utilisation) {
	    Optional<Utilisation> utilisationData = utilisationRepository.findById(id);
	    if (utilisationData.isPresent()) {
	      Utilisation _utilisation = utilisationData.get();
	      _utilisation.setEmplacement(utilisation.getEmplacement());
	      _utilisation.setUtilisation(utilisation.getUtilisation());
	      _utilisation.setResponsable(utilisation.getResponsable());
	      _utilisation.setEmplacementDoc(utilisation.getEmplacementDoc());
	      return new ResponseEntity<>(utilisationRepository.save(_utilisation), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	//////////////////// supprimer utilisation 
	  @DeleteMapping("/utilisations/{id}")
	  public ResponseEntity<HttpStatus> deleteUtilisation(@PathVariable("id") String id) {
	    try {
	      utilisationRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
}
