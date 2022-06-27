package com.example.demo.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Inventaire")
public class Inventaire {
	@Id
	private String reference;
	private String type;
	private  String marque;
	private String numSerie;
	private Date dateAquis;
	private Date dateMEP;
	private Date dateFinAquis;
	private String accessoire;
	private Utilisation utilisation;
	public Inventaire(){
		
		}
	public Inventaire(String reference, String type, String marque, String numSerie, Date dateAquis, Date dateMEP,
			Date dateFinAquis, String accessoire, Utilisation utilisation) {
		super();
		this.reference = reference;
		this.type = type;
		this.marque = marque;
		this.numSerie = numSerie;
		this.dateAquis = dateAquis;
		this.dateMEP = dateMEP;
		this.dateFinAquis = dateFinAquis;
		this.accessoire = accessoire;
		this.utilisation = utilisation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public Date getDateAquis() {
		return dateAquis;
	}
	public void setDateAquis(Date dateAquis) {
		this.dateAquis = dateAquis;
	}
	public Date getDateMEP() {
		return dateMEP;
	}
	public void setDateMEP(Date dateMEP) {
		this.dateMEP = dateMEP;
	}
	public Date getDateFinAquis() {
		return dateFinAquis;
	}
	public void setDateFinAquis(Date dateFinAquis) {
		this.dateFinAquis = dateFinAquis;
	}
	public String getAccessoire() {
		return accessoire;
	}
	public void setAccessoire(String accessoire) {
		this.accessoire = accessoire;
	}
	public Utilisation getUtilisation() {
		return utilisation;
	}
	public void setUtilisation(Utilisation utilisation) {
		this.utilisation = utilisation;
	}
	@Override
	public String toString() {
		return "Inventaire [reference=" + reference + ", type=" + type + ", marque=" + marque + ", numSerie=" + numSerie
				+ ", dateAquis=" + dateAquis + ", dateMEP=" + dateMEP + ", dateFinAquis=" + dateFinAquis
				+ ", accessoire=" + accessoire + ", utilisation=" + utilisation + "]";
	}

	
	

}
