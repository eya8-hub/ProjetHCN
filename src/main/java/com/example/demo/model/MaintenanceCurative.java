package com.example.demo.model;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MaintenanceCurative")
public class MaintenanceCurative extends Maintenance {
private Fournisseur fournisseur;
private String naturePanne;
private Decision decision;
private String description;
public MaintenanceCurative() {}
public MaintenanceCurative(Fournisseur fournisseur, String naturePanne, Decision decision, String description) {
	super();
	this.fournisseur = fournisseur;
	this.naturePanne = naturePanne;
	this.decision = decision;
	this.description = description;
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
	return "MaintenanceCurative [fournisseur=" + fournisseur + ", naturePanne=" + naturePanne + ", decision=" + decision
			+ ", description=" + description + "]";
}




}
