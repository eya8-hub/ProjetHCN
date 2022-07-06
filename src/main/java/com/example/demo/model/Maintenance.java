package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Maintenance")
public class Maintenance {
@Id
private String id;
private Date dateMaintenace;
private String natureMaintenace;
private Inventaire inventaire;


public Maintenance()
{
	}


public Maintenance(String id, Date dateMaintenace, String natureMaintenace, Inventaire inventaire) {
	super();
	this.id = id;
	this.dateMaintenace = dateMaintenace;
	this.natureMaintenace = natureMaintenace;
	this.inventaire = inventaire;
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


@Override
public String toString() {
	return "Maintenance [id=" + id + ", dateMaintenace=" + dateMaintenace + ", natureMaintenace=" + natureMaintenace
			+ ", inventaire=" + inventaire + "]";
}






}
