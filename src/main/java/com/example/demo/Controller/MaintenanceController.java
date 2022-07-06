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

import com.example.demo.model.Maintenance;
import com.example.demo.repository.MaintenanceRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
	@Autowired
	MaintenanceRepository maintenancerepo;
	
	 /////////////// ajouter maintenance
	  @PostMapping("/create")
	  public ResponseEntity<Maintenance> createTutorial(@RequestBody Maintenance maintenance) {
	    try {
		      Maintenance _maintenance = maintenancerepo.save(new Maintenance(maintenance.getId(),maintenance.getDateMaintenace(),maintenance.getNatureMaintenace(),maintenance.getInventaire()));

	      return new ResponseEntity<>(_maintenance, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
/////////////// afficher tous
@GetMapping("/maintenances")
public ResponseEntity<List<Maintenance>> getAllMaintenance(@RequestParam(required = false) String inventaire) {
try {
  List<Maintenance> maintenances = new ArrayList<Maintenance>();
  if (inventaire == null)
	  maintenancerepo.findAll().forEach(maintenances::add);
  else
	  maintenancerepo.findByInventaireContaining(inventaire).forEach(maintenances::add);
  if (maintenances.isEmpty()) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  return new ResponseEntity<>(maintenances, HttpStatus.OK);
} catch (Exception e) {
  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}

//////////////////////////////////
/////////////////methode update

@PutMapping("/maintenances/{id}")
public ResponseEntity<Maintenance> updateMaintenance(@PathVariable("id") String id, @RequestBody Maintenance maintenance) {
Optional<Maintenance> maintenanceData = maintenancerepo.findById(id);
if (maintenanceData.isPresent()) {
Maintenance _maintenance = maintenanceData.get();
_maintenance.setDateMaintenace(maintenance.getDateMaintenace());
_maintenance.setInventaire(maintenance.getInventaire());
_maintenance.setNatureMaintenace(maintenance.getNatureMaintenace());



return new ResponseEntity<>(maintenancerepo.save(_maintenance), HttpStatus.OK);
} else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
	  ///////delete
@DeleteMapping("/maintenances/{id}")
public ResponseEntity<HttpStatus> deleteMaintenance(@PathVariable("id") String id) {
  try {
	  maintenancerepo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
}
