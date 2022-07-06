package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Fournisseur")
public class Fournisseur {
	@Id
	private String id;
	private String fabriquant;
	private String jurant;
	private String adresse;
	private String matricule_fiscale;
	private String telephone;
	private String fax;
	private String visAvis;
	
	public Fournisseur() {
		
	}
	public Fournisseur(String id, String fabriquant, String jurant, String adresse, String matricule_fiscale,
			String telephone, String fax, String visAvis) {
		super();
		this.id = id;
		this.fabriquant = fabriquant;
		this.jurant = jurant;
		this.adresse = adresse;
		this.matricule_fiscale = matricule_fiscale;
		this.telephone = telephone;
		this.fax = fax;
		this.visAvis = visAvis;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFabriquant() {
		return fabriquant;
	}
	public void setFabriquant(String fabriquant) {
		this.fabriquant = fabriquant;
	}
	public String getJurant() {
		return jurant;
	}
	public void setJurant(String jurant) {
		this.jurant = jurant;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}
	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getVisAvis() {
		return visAvis;
	}
	public void setVisAvis(String visAvis) {
		this.visAvis = visAvis;
	}
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", fabriquant=" + fabriquant + ", jurant=" + jurant + ", adresse=" + adresse
				+ ", matricule_fiscale=" + matricule_fiscale + ", telephone=" + telephone + ", fax=" + fax
				+ ", visAvis=" + visAvis + "]";
	}
	 

}
