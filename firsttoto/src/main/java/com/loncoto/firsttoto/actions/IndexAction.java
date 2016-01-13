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
	
	public String index() {
		log.info("appel de index");
		taches = getTacheDAO().findAll();
		return SUCCESS;
	}

}
