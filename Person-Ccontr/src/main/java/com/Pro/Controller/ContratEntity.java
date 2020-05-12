package com.Pro.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContratEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)	
	private Long id;
	private String ref;
	private String numcontrat;
	
	
	@ManyToOne
    private PersonneEntity personneEntity;


	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getNumcontrat() {
		return numcontrat;
	}


	public void setNumcontrat(String numcontrat) {
		this.numcontrat = numcontrat;
	}


	public PersonneEntity getPersonneEntity() {
		return personneEntity;
	}


	public void setPersonneEntity(PersonneEntity personneEntity) {
		this.personneEntity = personneEntity;
	}

	public ContratEntity(Long id, String ref, String numcontrat) {
		super();
		this.id = id;
		this.ref = ref;
		this.numcontrat = numcontrat;
	}
	public ContratEntity() {
		super();
		this.id = id;
		this.ref = ref;
		this.numcontrat = numcontrat;
	}
	
	

}
