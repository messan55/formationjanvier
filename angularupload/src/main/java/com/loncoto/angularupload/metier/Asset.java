package com.loncoto.angularupload.metier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Asset implements IGenericEntity {
	private int id;
	private String name;
	private Date dateCreated;
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@Temporal(TemporalType.DATE)
	public Date getDateCreated() {return dateCreated;}
	public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}

	
	public Asset() {this(0, "", null); }
	public Asset(int id, String name, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}
	@Override
	public int fetchPrimaryKey() {
		return getId();
	}
	
	
}
