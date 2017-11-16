package com.app_jour_j.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private Long idParticipant;
	private String nom;
	private String prenom;
	private String statut; // etudiant ou autre
	private String etablissement;
	private String email;

	public Participant() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdParticipant() {
		return idParticipant;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getStatut() {
		return statut;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public String getEmail() {
		return email;
	}

	public void setIdParticipant(Long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {

		String str =  "Nom : " + this.getNom() 
					+ "\nPrenom : " + this.getPrenom()
					+ "\nStatut : " + this.getStatut()
					+ "\nEtablissement : " +this.getEtablissement()
					+ "\nE-mail : " + this.getEmail();
		return str;
	}

}
