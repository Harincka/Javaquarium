package com.javaquarium.beans.web;

import org.apache.struts.action.ActionForm;

public class PoissonVO extends ActionForm {

	private static final long serialVersionUID = -123456789L;
	private Integer code;
	private String description;
	private String couleur;
	private String dimension;
	private Integer prix;
	private String nom;
	
	
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	/**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public PoissonVO(){}
	
	public PoissonVO(String nom, String espece, String description, String couleur, String dimension, Integer prix){
		this.description = description;
		this.couleur = couleur;
		this.dimension = dimension;
		this.prix = prix;
		this.nom = nom;
	}
	

}