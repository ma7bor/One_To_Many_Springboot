package com.Pro.Controller;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class PersonneEntity implements Serializable{

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)	
private long id;

private String nom;

private String prenom;

private String email;

private String cin;



@OneToMany(mappedBy="personneEntity", cascade=CascadeType.ALL)
Set <ContratEntity> contratEntities;



public Set<ContratEntity> getContratEntities() {
	return contratEntities;
}



public void setContratEntities(Set<ContratEntity> contratEntities) {
	this.contratEntities = contratEntities;
}



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrenom() {
	return prenom;
}



public void setPrenom(String prenom) {
	this.prenom = prenom;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getCin() {
	return cin;
}



public void setCin(String cin) {
	this.cin = cin;
}



public PersonneEntity(long id, String nom, String prenom, String email, String cin) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.cin = cin;
}

public PersonneEntity() {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.cin = cin;
}



}
