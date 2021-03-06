package com.example.demo.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Inventaire")
public class Inventaire {
	@Id 
	private String id;
	private String reference;
	private Type type;
	private  String marque;
	private String numSerie;
	private Date dateAquis;
	private Date dateMEP;
	private Date dateFinAquis;
	private String accessoire;
	private Utilisation utilisation;
	public Inventaire(){
		
		}
	public Inventaire(String id,String reference, Type type, String marque, String numSerie, Date dateAquis, Date dateMEP,
			Date dateFinAquis, String accessoire,Utilisation utilisation) {
		super();
		this.id = id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
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
		return "Inventaire [id=" + id + ", reference=" + reference + ", type=" + type + ", marque=" + marque
				+ ", numSerie=" + numSerie + ", dateAquis=" + dateAquis + ", dateMEP=" + dateMEP + ", dateFinAquis="
				+ dateFinAquis + ", accessoire=" + accessoire + ", utilisation=" + utilisation + "]";
	}
	

	
	

}
