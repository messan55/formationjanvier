package com.loncoto.correc_exo1.actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loncoto.correc_exo1.dao.IProduitDAO;
import com.loncoto.correc_exo1.metier.Produit;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static Logger log = LogManager.getLogger(IndexAction.class);
	private static final long serialVersionUID = 1L;

	private IProduitDAO produitDAO;
	public void setProduitDAO(IProduitDAO produitDAO) {
		this.produitDAO = produitDAO;
	}


	private List<Produit> produits;
	public List<Produit> getProduits() {
		return produits;
	}

	public String index() {
		this.produits = produitDAO.findAll();
		return SUCCESS;
	}

}
