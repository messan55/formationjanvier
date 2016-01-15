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

	private int produitID;
	private String produitNom;
	private double produitPrix;
	private String produitCategorie;
	private int produitStock;
	
	public int getProduitID() {return produitID;}
	public void setProduitID(int produitID) {this.produitID = produitID;}
	public String getProduitNom() {return produitNom;}
	public void setProduitNom(String produitNom) {this.produitNom = produitNom;}
	public double getProduitPrix() {return produitPrix;}
	public void setProduitPrix(double produitPrix) {this.produitPrix = produitPrix;}
	public String getProduitCategorie() {return produitCategorie;}
	public void setProduitCategorie(String produitCategorie) {this.produitCategorie = produitCategorie;}
	public int getProduitStock() {return produitStock;}
	public void setProduitStock(int produitStock) {this.produitStock = produitStock;}
	
	private Produit produit;
	public Produit getProduit() {return produit;}
	

	private List<Produit> produits;
	public List<Produit> getProduits() {
		return produits;
	}

	public String index() {
		this.produits = produitDAO.findAll();
		return SUCCESS;
	}
	
	public String save() {
		log.info("nom produit = " + getProduitNom());
		this.produit = produitDAO.save(new Produit(getProduitID(),
													getProduitNom(),
													getProduitPrix(),
													getProduitCategorie(),
													getProduitStock()));
		return SUCCESS;
	}
	

}
