package br.com.recoleta.model;

import br.com.recoleta.enums.MaterialClassification;

//itens a serem coletados
public class WasteType {
	
	private Integer id;
	private String description;
	private MaterialClassification classification;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public MaterialClassification getClassification() {
		return classification;
	}
	public void setClassification(MaterialClassification classification) {
		this.classification = classification;
	}
	
	public WasteType(Integer id, String description, MaterialClassification classification) {
		super();
		this.id = id;
		this.description = description;
		this.classification = classification;
	}
	
}
