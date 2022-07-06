package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MaintenancePreventive")
public class MaintenancePreventive  {
@Id
private String id;
private Date dateMaintenace;
private String natureMaintenace;
private Inventaire inventaire;
private TypeMaintenance typeMaintenance;
private EtatMaintenance etat;
private Date prochaineMaintenace;
private String Description;
public MaintenancePreventive()
{
	}
public MaintenancePreventive(String id, Date dateMaintenace, String natureMaintenace, Inventaire inventaire,
		TypeMaintenance typeMaintenance, EtatMaintenance etat, Date prochaineMaintenace, String description) {
	super();
	this.id = id;
	this.dateMaintenace = dateMaintenace;
	this.natureMaintenace = natureMaintenace;
	this.inventaire = inventaire;
	this.typeMaintenance = typeMaintenance;
	this.etat = etat;
	this.prochaineMaintenace = prochaineMaintenace;
	Description = description;
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
public TypeMaintenance getTypeMaintenance() {
	return typeMaintenance;
}
public void setTypeMaintenance(TypeMaintenance typeMaintenance) {
	this.typeMaintenance = typeMaintenance;
}
public EtatMaintenance getEtat() {
	return etat;
}
public void setEtat(EtatMaintenance etat) {
	this.etat = etat;
}
public Date getProchaineMaintenace() {
	return prochaineMaintenace;
}
public void setProchaineMaintenace(Date prochaineMaintenace) {
	this.prochaineMaintenace = prochaineMaintenace;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
@Override
public String toString() {
	return "MaintenancePreventive [id=" + id + ", dateMaintenace=" + dateMaintenace + ", natureMaintenace="
			+ natureMaintenace + ", inventaire=" + inventaire + ", typeMaintenance=" + typeMaintenance + ", etat="
			+ etat + ", prochaineMaintenace=" + prochaineMaintenace + ", Description=" + Description + "]";
}


}
