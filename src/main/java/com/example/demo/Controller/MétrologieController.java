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
import com.example.demo.model.Métrologie;
import com.example.demo.repository.MetrologieRepository;
import com.example.demo.service.CSVService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/metrologie")
public class MétrologieController {
	 @Autowired
	  MetrologieRepository metrologieRepository;
	  CSVService fileService;
	  
	 /////////////// ajouter metrologie
	 
	 @PostMapping("/create")
	  public ResponseEntity<Métrologie> createMetrologie(@RequestBody Métrologie metrologie) {
	    try {
	      Métrologie _metrologie = metrologieRepository.save(new Métrologie(metrologie.getId(),metrologie.getInventaire(),metrologie.getDateMetrologie(),metrologie.getDateProchaineMetrologie(),metrologie.getDescription(),true));
	      return new ResponseEntity<>(_metrologie, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 //////////////////// afficher métrologies
	 
	 @GetMapping("/metrologies")
	  public ResponseEntity<List<Métrologie>> getAllMetrologies(@RequestParam(required = false) Inventaire inventaire) {
	    try {
	      List<Métrologie> metrologies = new ArrayList<Métrologie>();
	      if (inventaire == null)
	        metrologieRepository.findAll().forEach(metrologies::add);
	      else
	        metrologieRepository.findByInventaireContaining(inventaire).forEach(metrologies::add);
	      if (metrologies.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(metrologies, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    }
	 ////////////// modifier metrologie
	 
	 @PutMapping("/metrologie/{id}")
	  public ResponseEntity<Métrologie> updateMetrologie(@PathVariable("id") String id, @RequestBody Métrologie metrologie) {
	    Optional<Métrologie> metrologieData = metrologieRepository.findById(id);
	    if (metrologieData.isPresent()) {
	      Métrologie _metrologie = metrologieData.get();
	      _metrologie.setInventaire(metrologie.getInventaire());
	      _metrologie.setDateMetrologie(metrologie.getDateMetrologie());
	      _metrologie.setDateProchaineMetrologie(metrologie.getDateProchaineMetrologie());
	      _metrologie.setDescription(metrologie.getDescription());
	      _metrologie.setPublished(metrologie.isPublished());


	      return new ResponseEntity<>(metrologieRepository.save(_metrologie), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 /////////////// supprimer metrologie 
	 @DeleteMapping("/metrologie/{id}")
	  public ResponseEntity<HttpStatus> deleteMetrologie(@PathVariable("id") String id) {
	    try {
	      metrologieRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
}
