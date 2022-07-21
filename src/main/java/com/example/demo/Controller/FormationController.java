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

import com.example.demo.model.Formation;
import com.example.demo.repository.FormationRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/formation")
public class FormationController {
	
	 @Autowired
	 FormationRepository formationRepository;
	 
	 //////////// ajouter formation
	 @PostMapping("/create")
	  public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
	    try {
	      Formation _formation = formationRepository.save(new Formation(formation.getId(),formation.getTitre(), formation.getDate(),true,formation.getFormateur(),formation.getPersonnels(),formation.getDescription()));
	      return new ResponseEntity<>(_formation, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 ////////////// afficher  tous les formations
	 @GetMapping("/formations")
	  public ResponseEntity<List<Formation>> getAllFormations(@RequestParam(required = false) String titre) {
	    try {
	      List<Formation> formations = new ArrayList<Formation>();
	      if (titre == null)
	        formationRepository.findAll().forEach(formations::add);
	      else
	        formationRepository.findByTitreContaining(titre).forEach(formations::add);
	      if (formations.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(formations, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 //////////////// afficher les formations selon leur id
	 @GetMapping("/formations/{id}")
	  public ResponseEntity<Formation> getFormationById(@PathVariable("id") String id) {
	    Optional<Formation> formationData = formationRepository.findById(id);
	    if (formationData.isPresent()) {
	      return new ResponseEntity<>(formationData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 /////////////// afficher les formations réalisées
	 @GetMapping("/formations/realisee")
	  public ResponseEntity<List<Formation>> findByRealise() {
	    try {
	      List<Formation> formations = formationRepository.findByRealise(true);
	      if (formations.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(formations, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 ////////////////modifier formation

	  @PutMapping("/formation/{id}")
	 public ResponseEntity<Formation> updateFormation(@PathVariable("id") String id, @RequestBody Formation formation) {
		    Optional<Formation> tutorialData = formationRepository.findById(id);
		    if (tutorialData.isPresent()) {
		      Formation _formation = tutorialData.get();
		      _formation.setTitre(formation.getTitre());
		      _formation.setDate(formation.getDate());
		      _formation.setFormateur(formation.getFormateur());
		      _formation.setPersonnels(formation.getPersonnels());
		      _formation.setDescription(formation.getDescription());
		      _formation.setReaslise(formation.isRealise());
		      
		      return new ResponseEntity<>(formationRepository.save(_formation), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }
	 /////////////////////// effacer formation
	  @DeleteMapping("/formation/{id}")
	  public ResponseEntity<HttpStatus> deleteFormation(@PathVariable("id") String id) {
	    try {
	      formationRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
//////////////
	  
	  
}
