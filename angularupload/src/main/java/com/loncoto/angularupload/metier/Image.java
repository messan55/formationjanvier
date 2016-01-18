package com.loncoto.angularupload.metier;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Image extends Asset {
	private String fileName;
	private String contentType;
	
	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	public String getContentType() {return contentType;}
	public void setContentType(String contentType) {this.contentType = contentType;}
	
	public Image() {this(0, "", null, "", ""); }
	public Image(int id, String name, Date dateCreated, String fileName, String contentType) {
		super(id, name, dateCreated);
		this.fileName = fileName;
		this.contentType = contentType;
	}
	
	
}
