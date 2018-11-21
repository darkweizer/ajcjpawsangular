package com.formation.ajcjpaawangular.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer idAdress;
	private String libelle;
	private String street;
	private int zipcode;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "adress_idUser")
	private User user;

	public Adress() {
	}

	public Adress(String libelle, String street, int zipcode) {
		super();
		this.libelle = libelle;
		this.street = street;
		this.zipcode = zipcode;
	}
	

	public Integer getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(Integer idAdress) {
		this.idAdress = idAdress;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Adress [idAdress=" + idAdress + ", libelle=" + libelle + ", street=" + street + ", zipcode=" + zipcode
				+ "]";
	}

}
