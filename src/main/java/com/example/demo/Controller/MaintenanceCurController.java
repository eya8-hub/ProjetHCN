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

import com.example.demo.model.MaintenanceCurative;
import com.example.demo.repository.MaintenanceCurRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/MaintenanceCurative")
public class MaintenanceCurController {
	 @Autowired
	 MaintenanceCurRepository maintenanceCurRepository;
/////////////// ajouter
@PostMapping("/create")
public ResponseEntity<MaintenanceCurative> createMC(@RequestBody MaintenanceCurative maintenanceCurative) {
try {
	MaintenanceCurative _maintenanceCurative = maintenanceCurRepository.save(new MaintenanceCurative(maintenanceCurative.getFournisseur(),maintenanceCurative.getNaturePanne(),maintenanceCurative.getDecision(),maintenanceCurative.getDescription()));
 return new ResponseEntity<>(_maintenanceCurative, HttpStatus.CREATED);
} catch (Exception e) {
 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
//////////// lister 
@GetMapping("/maintenancesCurative")
public ResponseEntity<List<MaintenanceCurative>> getAllMC(@RequestParam(required = false) String inventaire) {
  try {
    List<MaintenanceCurative> mainCurs = new ArrayList<MaintenanceCurative>();
    if (inventaire == null)
    	maintenanceCurRepository.findAll().forEach(mainCurs::add);
    else
    	maintenanceCurRepository.findByInventaireContaining(inventaire).forEach(mainCurs::add);
    if (mainCurs.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(mainCurs, HttpStatus.OK);
  } catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
//////////////////update
@PutMapping("/maintenanceCur/{id}")
public ResponseEntity<MaintenanceCurative> updateTutorial(@PathVariable("id") String id, @RequestBody MaintenanceCurative MainCur) {
  Optional<MaintenanceCurative> tutorialData = maintenanceCurRepository.findById(id);
  if (tutorialData.isPresent()) {
    MaintenanceCurative _Maincur = tutorialData.get();
    _Maincur.setFournisseur(MainCur.getFournisseur());
    _Maincur.setNaturePanne(MainCur.getNaturePanne());
    _Maincur.setDecision(MainCur.getDecision());
    _Maincur.setDescription(MainCur.getDescription());
   
    return new ResponseEntity<>(maintenanceCurRepository.save( _Maincur), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
//////////////////delete
///////////////// methode delete
@DeleteMapping("/maintenanceCur/{id}")
public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
try {
	maintenanceCurRepository.deleteById(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
} catch (Exception e) {
return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}
}
