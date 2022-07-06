package com.example.demo.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MaintenanceCurative")
public class MaintenancePreventive extends Maintenance {

private TypeMaintenance typeMaintenance;
private EtatMaintenance etat;
private Date prochaineMaintenace;
private String Description;
public MaintenancePreventive()
{
	}
public MaintenancePreventive(TypeMaintenance typeMaintenance, EtatMaintenance etat, Date prochaineMaintenace,String Description) {
	super();
	this.typeMaintenance = typeMaintenance;
	this.etat = etat;
	this.prochaineMaintenace = prochaineMaintenace;
	this.Description=Description;
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
	return "MaintenancePreventive [typeMaintenance=" + typeMaintenance + ", etat=" + etat + ", prochaineMaintenace="
			+ prochaineMaintenace + ", Description=" + Description + "]";
}






}
