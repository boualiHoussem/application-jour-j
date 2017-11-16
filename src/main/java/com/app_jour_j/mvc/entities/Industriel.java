package com.app_jour_j.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Industriel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private Long idIndustriel;
	private String nom;
	private String prenom;
	private String poste;
	private String entreprise;
	private Long numeroTelephone;
	private String email;

	public Industriel() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdIndustriel() {
		return idIndustriel;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getPoste() {
		return poste;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public Long getNumeroTelephone() {
		return numeroTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setIdIndustriel(Long idIndustriel) {
		this.idIndustriel = idIndustriel;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public void setNumeroTelephone(Long numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {

		String str =  "Nom : " + this.getNom() 
					+ "\nPrenom : " + this.getPrenom()
					+ "\nPoste : " + this.getPoste()
					+ "\nEntreprise : " +this.getEntreprise()
					+ "\nN° Telephone : " + this.getNumeroTelephone()
					+ "\nE-mail : " + this.getEmail();
		return str;
	}
}
