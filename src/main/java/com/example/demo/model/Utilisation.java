package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UtilisationInv")
public class Utilisation {
	@Id
	private String id;
    private String emplacement;
    private String utilisation;
    private String responsable;
    private String emplacementDoc;
    
    public Utilisation() {
    	
    }

	public Utilisation(String id, String emplacement, String utilisation, String responsable, String emplacementDoc) {
		super();
		this.id = id;
		this.emplacement = emplacement;
		this.utilisation = utilisation;
		this.responsable = responsable;
		this.emplacementDoc = emplacementDoc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getUtilisation() {
		return utilisation;
	}

	public void setUtilisation(String utilisation) {
		this.utilisation = utilisation;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEmplacementDoc() {
		return emplacementDoc;
	}

	public void setEmplacementDoc(String emplacementDoc) {
		this.emplacementDoc = emplacementDoc;
	}

	@Override
	public String toString() {
		return "Utilisation [id=" + id + ", emplacement=" + emplacement + ", utilisation=" + utilisation
				+ ", responsable=" + responsable + ", emplacementDoc=" + emplacementDoc + "]";
	}
    

}
