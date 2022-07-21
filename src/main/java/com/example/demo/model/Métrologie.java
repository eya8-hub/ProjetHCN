package com.example.demo.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Metrologie")
public class Métrologie {
	private String id;
	private Inventaire inventaire;
	private Date DateMetrologie;
	private Date DateProchaineMetrologie;
	private String Description;
    private boolean published;

	
	public Métrologie() {
		
	}
	public Métrologie(String id, Inventaire inventaire, Date dateMetrologie, Date dateProchaineMetrologie,
			String description ,Boolean published) {
		
		this.id = id;
		this.inventaire = inventaire;
		DateMetrologie = dateMetrologie;
		DateProchaineMetrologie = dateProchaineMetrologie;
		Description = description;
		this.published=published;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	public Date getDateMetrologie() {
		return DateMetrologie;
	}
	public void setDateMetrologie(Date dateMetrologie) {
		DateMetrologie = dateMetrologie;
	}
	public Date getDateProchaineMetrologie() {
		return DateProchaineMetrologie;
	}
	public void setDateProchaineMetrologie(Date dateProchaineMetrologie) {
		DateProchaineMetrologie = dateProchaineMetrologie;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	

}
