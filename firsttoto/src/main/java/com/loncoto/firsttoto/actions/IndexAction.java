package com.loncoto.firsttoto.actions;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loncoto.firsttoto.dao.ITacheDAO;
import com.loncoto.firsttoto.metier.Tache;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static Logger log = LogManager.getLogger(IndexAction.class);
	
	private static final long serialVersionUID = 1L;

	private ITacheDAO tacheDAO;
	public ITacheDAO getTacheDAO() {return tacheDAO;}
	public void setTacheDAO(ITacheDAO tacheDAO) {this.tacheDAO = tacheDAO;}

	private List<Tache> taches;
	public List<Tache> getTaches() {
		return taches;
	}
	
	private Tache tache;
	public Tache getTache() {return tache;}

	private int tacheID;
	private String tacheLibelle;
	private String tacheCategory;
	private boolean tacheCompleted;
	private Date tacheDateCreated;
	
	public int getTacheID() {return tacheID;}
	public void setTacheID(int tacheID) {this.tacheID = tacheID;}
	public String getTacheLibelle() {return tacheLibelle;}
	public void setTacheLibelle(String tacheLibelle) {this.tacheLibelle = tacheLibelle;}
	public String getTacheCategory() {return tacheCategory;}
	public void setTacheCategory(String tacheCategory) {this.tacheCategory = tacheCategory;}
	public boolean getTacheCompleted() {return tacheCompleted;}
	public void setTacheCompleted(boolean tacheCompleted) {	this.tacheCompleted = tacheCompleted;}
	public Date getTacheDateCreated() {return tacheDateCreated;}
	public void setTacheDateCreated(Date tacheDateCreated) {this.tacheDateCreated = tacheDateCreated;}
	
	
	public String index() {
		log.info("appel de index");
		taches = getTacheDAO().findAll();
		return SUCCESS;
	}
	
	public String save() {
		Tache t = new Tache(getTacheID(), getTacheLibelle(), null, getTacheCompleted(), getTacheCategory());
		this.tache =  getTacheDAO().save(t);
		return SUCCESS;
	}

}
