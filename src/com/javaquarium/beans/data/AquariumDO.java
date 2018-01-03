package com.javaquarium.beans.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Aquarium")
public class AquariumDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name= "user_id")
	private UserDO id_user;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name= "poisson_id")
	private PoissonDO id_poisson;
	
	@Column(name= "somme")
	private Integer somme;
	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id_user
	 */
	public UserDO getId_user() {
		return id_user;
	}

	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(UserDO id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the id_poisson
	 */
	public PoissonDO getId_poisson() {
		return id_poisson;
	}

	/**
	 * @param id_poisson the id_poisson to set
	 */
	public void setId_poisson(PoissonDO id_poisson) {
		this.id_poisson = id_poisson;
	}
	
	/**
	 * @return the somme
	 */
	public Integer getSomme() {
		return somme;
	}

	/**
	 * @param somme the somme to set
	 */
	public void setSomme(Integer somme) {
		this.somme = somme;
	}

	public AquariumDO(){
		
	}
	

}