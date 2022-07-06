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

import com.example.demo.model.MaintenancePreventive;
import com.example.demo.repository.MaintenancePrevRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/MaintenancePreventive")
public class MaintenancePrevController {
	 @Autowired
	 MaintenancePrevRepository maintPrevRepo;
/////////////// ajouter
@PostMapping("/create")
public ResponseEntity<MaintenancePreventive> createMP(@RequestBody MaintenancePreventive maintenancePrev) {
try {
MaintenancePreventive _maintenancePrev = maintPrevRepo.save(new MaintenancePreventive(maintenancePrev.getId(),maintenancePrev.getDateMaintenace(),maintenancePrev.getNatureMaintenace(),maintenancePrev.getInventaire(),maintenancePrev.getTypeMaintenance(),maintenancePrev.getEtat(),maintenancePrev.getProchaineMaintenace(),maintenancePrev.getDescription()));
return new ResponseEntity<>(_maintenancePrev, HttpStatus.CREATED);
} catch (Exception e) {
return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
////////////lister 
@GetMapping("/maintenancesCurative")
public ResponseEntity<List<MaintenancePreventive>> getAllMC(@RequestParam(required = false) String inventaire) {
try {
List<MaintenancePreventive> mainPrev = new ArrayList<MaintenancePreventive>();
if (inventaire == null)
	maintPrevRepo.findAll().forEach(mainPrev::add);
else
	maintPrevRepo.findByInventaireContaining(inventaire).forEach(mainPrev::add);
if (mainPrev.isEmpty()) {
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
return new ResponseEntity<>(mainPrev, HttpStatus.OK);
} catch (Exception e) {
return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
//////////////////update
@PutMapping("/maintenanceCur/{id}")
public ResponseEntity<MaintenancePreventive> updateTutorial(@PathVariable("id") String id, @RequestBody MaintenancePreventive MainPrev) {
Optional<MaintenancePreventive> tutorialData = maintPrevRepo.findById(id);
if (tutorialData.isPresent()) {
MaintenancePreventive _MainPrev = tutorialData.get();
_MainPrev.setId(MainPrev.getId());
_MainPrev.setDateMaintenace(MainPrev.getDateMaintenace());
_MainPrev.setNatureMaintenace(MainPrev.getNatureMaintenace());
_MainPrev.setInventaire(MainPrev.getInventaire());
_MainPrev.setTypeMaintenance(MainPrev.getTypeMaintenance());
_MainPrev.setEtat(MainPrev.getEtat());
_MainPrev.setProchaineMaintenace(MainPrev.getProchaineMaintenace());
_MainPrev.setDescription(MainPrev.getDescription());

return new ResponseEntity<>(maintPrevRepo.save( _MainPrev), HttpStatus.OK);
} else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
//////////////////delete
///////////////// methode delete
@DeleteMapping("/maintenanceCur/{id}")
public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
try {
	maintPrevRepo.deleteById(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
} catch (Exception e) {
return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	 
	 
	 
}
