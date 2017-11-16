package com.app_jour_j.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enseignant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private Long idProfessor;
	private String nom;
	private String prenom;
	private String grade;

	public Enseignant() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getGrade() {
		return grade;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {

		String str = "Nom : " + this.getNom() 
					+ "\nPrenom : " + this.getPrenom()
					+ "\nGrade : " + this.getGrade();
		return str;
	}

}
