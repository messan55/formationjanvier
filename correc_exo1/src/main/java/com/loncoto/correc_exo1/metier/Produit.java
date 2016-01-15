package com.loncoto.correc_exo1.metier;

public class Produit implements IGenericEntity {

	private int id;
	private String nom;
	private double prix;
	private String categorie;
	private int stock;

	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public Produit() {this(0, "", 0.0,"", 0); }
	public Produit(int id, String nom, double prix, String categorie, int stock) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.stock = stock;
	}
	
	@Override
	public int fetchPrimaryKey() {
		return getId();
	}

}
