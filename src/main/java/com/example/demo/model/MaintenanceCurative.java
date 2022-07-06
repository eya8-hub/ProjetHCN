package com.example.demo.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MaintenanceCurative")
public class MaintenanceCurative {
@Id
private String id;
private Date dateMaintenace;
private String natureMaintenace;
private Inventaire inventaire;
private Fournisseur fournisseur;
private String naturePanne;
private Decision decision;
private String description;
public MaintenanceCurative() {}
public MaintenanceCurative(String id, Date dateMaintenace, String natureMaintenace, Inventaire inventaire,
		Fournisseur fournisseur, String naturePanne, Decision decision, String description) {
	super();
	this.id = id;
	this.dateMaintenace = dateMaintenace;
	this.natureMaintenace = natureMaintenace;
	this.inventaire = inventaire;
	this.fournisseur = fournisseur;
	this.naturePanne = naturePanne;
	this.decision = decision;
	this.description = description;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Date getDateMaintenace() {
	return dateMaintenace;
}
public void setDateMaintenace(Date dateMaintenace) {
	this.dateMaintenace = dateMaintenace;
}
public String getNatureMaintenace() {
	return natureMaintenace;
}
public void setNatureMaintenace(String natureMaintenace) {
	this.natureMaintenace = natureMaintenace;
}
public Inventaire getInventaire() {
	return inventaire;
}
public void setInventaire(Inventaire inventaire) {
	this.inventaire = inventaire;
}
public Fournisseur getFournisseur() {
	return fournisseur;
}
public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}
public String getNaturePanne() {
	return naturePanne;
}
public void setNaturePanne(String naturePanne) {
	this.naturePanne = naturePanne;
}
public Decision getDecision() {
	return decision;
}
public void setDecision(Decision decision) {
	this.decision = decision;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "MaintenanceCurative [id=" + id + ", dateMaintenace=" + dateMaintenace + ", natureMaintenace="
			+ natureMaintenace + ", inventaire=" + inventaire + ", fournisseur=" + fournisseur + ", naturePanne="
			+ naturePanne + ", decision=" + decision + ", description=" + description + "]";
}





}
