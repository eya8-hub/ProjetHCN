package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Formation")
public class Formation {
@Id
private String id;
private String titre;
private Date date;
private boolean realise;
private String formateur;
private String personnels;
private String description;
public Formation() {
	
}

public Formation(String id, String titre, Date date, boolean realise, String formateur, String personnels,
		String description) {
	super();
	this.id = id;
	this.titre = titre;
	this.date = date;
	this.realise = realise;
	this.formateur = formateur;
	this.personnels = personnels;
	this.description = description;
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getFormateur() {
	return formateur;
}
public void setFormateur(String formateur) {
	this.formateur = formateur;
}
public String getPersonnels() {
	return personnels;
}
public void setPersonnels(String personnels) {
	this.personnels = personnels;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public boolean isRealise() {
	return realise;
}

public void setReaslise(boolean published) {
	this.realise = published;
}

@Override
public String toString() {
	return "Formation [id=" + id + ", titre=" + titre + ", date=" + date + ", realise=" + realise + ", formateur="
			+ formateur + ", personnels=" + personnels + ", description=" + description + "]";
}




	

}
