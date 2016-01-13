package com.loncoto.firsttoto.metier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tache {
	private int id;
	private String libelle;
	private Date dateCreated;
	private boolean completed;
	private String category;
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
	@Temporal(TemporalType.DATE)
	public Date getDateCreated() {return dateCreated;}
	public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}
	
	public boolean isCompleted() {return completed;}
	public void setCompleted(boolean completed) {this.completed = completed;}
	
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
	
	public Tache() {this(0, "", null, false, ""); }
	public Tache(int id, String libelle, Date dateCreated, boolean completed, String category) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateCreated = dateCreated;
		this.completed = completed;
		this.category = category;
	}
	
	

}
